class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        Queue<Integer> q = new LinkedList();
        int h = board.length, w = board[0].length;
        for(int i = 0; i < h; i++){
            if(board[i][0] == 'O') {q.add(i*w);
                                    board[i][0] = '1';
                                   }
            if(board[i][w-1] == 'O') {q.add(i*w+w-1);
                                     board[i][w-1] = '1';
                                     }
        }
        for(int i = 1; i < w-1; i++){
            if(board[0][i] == 'O') {q.add(i);board[0][i] = '1';}
            if(board[h-1][i] == 'O') {q.add((h-1)*w+i);
                                     board[h-1][i] = '1';
                                     }
        }
        int curr = 0, currC = 0, currR = 0, nextC = 0, nextR  = 0;
        int[][] offsets = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            curr = q.poll();
            currR = curr/w;
            currC = curr%w;
            
            for(int i = 0; i < 4; i++){
                int[] offset = offsets[i];
                nextR = currR+offset[0];
                nextC = currC+offset[1];
                if(nextR >= 0 && nextR < h && nextC >= 0 && nextC < w){
                    if(board[nextR][nextC] == 'O'){
                        board[nextR][nextC] = '1';
                        q.add(nextR*w+nextC);
                    } 
                    
                }
            }
        }
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}
//bfs from edges
