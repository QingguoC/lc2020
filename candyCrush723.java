class Solution {
    public int[][] candyCrush(int[][] board) {
        int h = board.length, w = board[0].length;
        boolean anyCrush = false;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w - 2; j++){
                int currV = Math.abs(board[i][j]);
                if(currV > 0 && currV == Math.abs(board[i][j+1]) && currV == Math.abs(board[i][j+2])){
                    board[i][j] = board[i][j+1] = board[i][j+2] = -currV;
                    anyCrush = true;
                }
            }
        }
        for(int i = 0; i < h - 2; i++){
            for(int j = 0; j < w; j++){
                int currV = Math.abs(board[i][j]);
                if(currV > 0 && currV == Math.abs(board[i+1][j]) && currV == Math.abs(board[i+2][j])){
                    board[i][j] = board[i+1][j] = board[i+2][j] = -currV;
                    anyCrush = true;
                }
            }
        }
        for(int i = 0; i < w; i++){
            int r = h -1;
            for(int j = h-1; j >= 0; j--){
                if(board[j][i] > 0){
                    board[r--][i] = board[j][i];
                }
            }
            for(int j = r; j >= 0; j--){
                board[j][i] = 0;
            }
        }
        return  anyCrush? candyCrush(board) :board;
        
    }
}
//negative to memorize, pointer to move
