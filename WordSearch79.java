class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(dfs(board, word, r,c, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int i){
        if(r >= board.length || r < 0 || c >= board[0].length || c < 0 ) {
            return false;
        }
        if(i == word.length()-1 && board[r][c] == word.charAt(i)){
            return true;
        }
        if(board[r][c] != word.charAt(i)){
            return false;
        }
        char tmp = board[r][c];
        board[r][c] = '#';
        boolean res = dfs(board, word, r-1, c, i+1) || dfs(board, word, r+1, c, i+1) || dfs(board, word, r, c-1, i+1) || dfs(board, word, r, c+1, i+1);
        board[r][c] = tmp;
        return res;
        
        
    }
}

//dfs modify board when visit and after dfs change back.
