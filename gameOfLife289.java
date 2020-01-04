class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        //0 to 1 as 2; 1 to 0 as 3
        int dead = 0, alive = 0;
        int w = board[0].length, h = board.length;
        for(int i=0; i < h; i++){
            for(int j=0; j<w; j++){
                dead = 0;
                alive = 0;
                for(int m: Arrays.asList(-1,0, 1)){
                    for(int n: Arrays.asList(-1,0, 1)){
                        if(!(m==0 && n==0)){
                            if(i+m >= 0 && i+m < h && j+n >=0 && j+n < w){
                            if(board[i+m][j+n]%2==0){
                                dead++;
                            }else{
                                alive++;
                            }    
                            }
                        }
                    }
                }
                if(alive < 2){
                    if(board[i][j] == 1){
                        board[i][j] = 3;
                    }
                } else if(alive == 2 || alive == 3){
                    if(board[i][j] == 1){
                        board[i][j] = 1;
                    } else if(alive == 3){
                        if(board[i][j] == 0){
                        board[i][j] = 2;
                    }
                }
                } else if(alive > 3){
                    if(board[i][j] == 1){
                        board[i][j] = 3;
                    }
                } 
                
                
            }
        }
        
        for(int i=0; i < h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
}

//inplace encode and reverse back
