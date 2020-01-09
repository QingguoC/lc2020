class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        int[][] dists = new int[h][w];
        Queue<Integer> q = new LinkedList(), newQ;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(matrix[i][j] == 0){
                    q.offer(i*w+j);
                }
            }
        }
        int[][] offsets = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int dist = 0;
        int currC = 0, currR = 0, nextC = 0, nextR = 0;
        while(!q.isEmpty()){
            newQ = new LinkedList();
            dist++;
            for(int curr:q){
                currR = curr/w;
                currC = curr%w;
                for(int i = 0; i < 4; i++){
                    nextR = offsets[i][0] + currR;
                    nextC = offsets[i][1] + currC;
                    if(nextR >= 0 && nextR < h && nextC >= 0 && nextC < w && matrix[nextR][nextC] != 0) {
                        newQ.offer(nextR*w+nextC);
                        dists[nextR][nextC] = dist;
                        matrix[nextR][nextC] = 0;
                    }
                
                }
            }
            q = newQ; 
        }
        return dists;
    }
}
//bfs
