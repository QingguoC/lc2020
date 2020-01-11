class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length < 2 || heightMap[0].length < 2) return 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((Cell c1, Cell c2) -> c1.height - c2.height);
        int h = heightMap.length, w = heightMap[0].length;
        
        HashSet<Integer> visited = new HashSet();
        int currH = 0, currC = 0, currR = 0, nextH = 0, nextC = 0, nextR = 0;
        int[][] offsets = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int res = 0;
        for(int i = 0; i < h; i++){
            pq.add(new Cell(i,0,heightMap[i][0]));
            pq.add(new Cell(i,w-1,heightMap[i][w-1]));
            visited.add(i*w);
            visited.add(i*w+w-1);
        }
        for(int i = 1; i < w-1; i++){
            pq.add(new Cell(0,i,heightMap[0][i]));
            pq.add(new Cell(h-1,i,heightMap[h-1][i]));
            visited.add(i);
            visited.add((h-1)*w+i);
        }
        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            currH = cell.height;
            currC = cell.c;
            currR = cell.r;
            for(int i = 0; i < 4; i++){
                nextC = currC + offsets[i][1];
                nextR = currR + offsets[i][0];
                if(nextC >= 0 && nextR >= 0 && nextC < w && nextR < h && !visited.contains(nextR*w+nextC)){
                    nextH = heightMap[nextR][nextC];
                    visited.add(nextR*w+nextC);
                    if(nextH < currH){
                        res += currH - nextH;
                        pq.add(new Cell(nextR, nextC, currH));
                    }else{
                        pq.add(new Cell(nextR, nextC, nextH));
                    }
                }
            }
        }
        return res;
    }
}
class Cell {
    int r;
    int c;
    int height;
    public Cell(int row, int col, int h){
        this.r  = row;
        this.c = col;
        this.height = h;
    }
    public void setHeight(int h){
        this.height = h;
    }
}

//PQ to start from border, choose min height to cal max water because it always indicates the limit of neighbor cell volume, once fill, use the min h to replace neighbor height
