class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int h = grid.length, w = grid[0].length;
        Queue<Integer> queue = new LinkedList(), newQ;
        int numOfGoods = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(grid[i][j] == 2){
                    queue.add(i*w+j);
                } else if(grid[i][j] == 1){
                    numOfGoods++;
                }
            }
        }
        if(queue.isEmpty()) {
            if(numOfGoods == 0) return 0;
            return -1;
        }
        int minutes = 0,  nextC = 0, nextR = 0, currC = 0, currR = 0;
        int[][] offsets = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            newQ = new LinkedList();
            minutes++;
            for(int curr: queue){
                currC = curr%w;
                currR = curr/w;
                for(int i = 0; i < 4; i++){
                    int[] offset = offsets[i];
                    nextC = currC + offset[1];
                    nextR = currR + offset[0];
                    if(nextC >= 0 && nextC < w && nextR >= 0 && nextR < h && grid[nextR][nextC] == 1){
                        newQ.add(nextR*w+nextC);
                        grid[nextR][nextC] = 2;
                    }
                }
            }
            queue = newQ;
            
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minutes-1;
    }
}
//bfs pay attention to corner case
