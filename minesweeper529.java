class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int currR = click[0], currC = click[1], h = board.length, w = board[0].length, curr = currR*w+currC, next = 0, nextC = 0, nextR = 0, cntB = 0;
        int[][] dirs = new int[][]{{1,0},{1,1},{0,1},{1,-1},{-1,1},{-1,-1},{-1,0},{0,-1}}; 
        HashSet<Integer> visit = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.offer(curr);
        visit.add(curr);
        while(!q.isEmpty()){
            curr = q.poll();
            currR = curr/w;
            currC = curr%w;
            if(board[currR][currC] == 'M'){
                board[currR][currC] = 'X';
                break;
            }
            cntB = 0;
            for(int i = 0; i < 8; i++){
                nextR = currR + dirs[i][0];
                nextC = currC + dirs[i][1];
                next = nextR*w+nextC;
                if(nextR>=0 && nextR < h && nextC >= 0 && nextC < w){
                    if(board[nextR][nextC] == 'M'){
                        cntB++;
                    } 
                }
            }
            board[currR][currC] = cntB == 0 ? 'B' : ("" + cntB).charAt(0);
            if(cntB == 0){
                for(int i = 0; i < 8; i++){
                nextR = currR + dirs[i][0];
                nextC = currC + dirs[i][1];
                next = nextR*w+nextC;
                if(nextR>=0 && nextR < h && nextC >= 0 && nextC < w && !visit.contains(next) && board[nextR][nextC] == 'E'){
                    
                        visit.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        
        return board;
    }
}
//bfs, when cntM == 0  then bfs add next
