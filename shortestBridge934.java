class Solution {
    public int shortestBridge(int[][] A) {
        int start = -1, h = A.length, w = A[0].length;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(A[i][j] == 1){
                    start = i * w + j;
                    A[i][j] = 2;
                    break;
                }
            }
            if(start != -1) break;
        }
        Queue<Integer> q = new LinkedList(), border = new LinkedList(), newQ;
        int[][] offsets = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int curr = 0, currC = 0, currR = 0, nextC = 0, nextR = 0, res = 0;
        boolean isBorder = false;
        q.offer(start);
        while(!q.isEmpty()){
            curr = q.poll();
            isBorder = false;
            currC = curr%w;
            currR = curr/w;
            for(int i = 0; i < 4; i++){
                nextC = currC + offsets[i][1];
                nextR = currR + offsets[i][0];
                if(nextC >= 0 && nextC < w && nextR >= 0 && nextR < h){
                    if(A[nextR][nextC] == 1){
                        q.offer(nextR*w+nextC);
                        A[nextR][nextC] = 2;
                    } else if(A[nextR][nextC] == 0) {
                        isBorder = true;
                    }
                }
            }
            if(isBorder){
                border.offer(curr);
            }
        }
        while(!border.isEmpty()){
            newQ = new LinkedList();
            res++;
            for(int b: border){
                currC = b%w;
                currR = b/w;
                for(int i = 0; i < 4; i++){
                    nextC = currC + offsets[i][1];
                    nextR = currR + offsets[i][0];
                    if(nextC >= 0 && nextC < w && nextR >= 0 && nextR < h) {
                        if(A[nextR][nextC] == 1) {
                            return res-1;
                        }
                        if(A[nextR][nextC] == 0){
                            newQ.offer(nextR*w+nextC);
                            A[nextR][nextC] = 2;
                        }
                    
                    
                    }
                }
            }
            border = newQ;
            
        }
        return res-1;
    }
}
//bfs to find an island and its border, do another bfs from border
