class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int[][] dp = new int[h][w]; //longest path starting from 
        //int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int res = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(dp[i][j] == 0){
                   res = Math.max(res, helper(matrix, dp, i,j, w,h, Integer.MIN_VALUE)); 
                } else{
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
    private int helper(int[][] matrix, int[][] dp, int r, int c,  int w, int h, int prev){
        if(r >= h || r < 0 || c < 0 || c >= w || matrix[r][c] <= prev) return 0;
        if(dp[r][c] > 0) return dp[r][c];
        int res = 0;
        res = Math.max(res, helper(matrix, dp, r+1, c, w, h, matrix[r][c]));
        res = Math.max(res,helper(matrix, dp, r-1, c, w, h, matrix[r][c]));
        res = Math.max(res, helper(matrix, dp, r, c+1, w, h, matrix[r][c]));
        res = Math.max(res,helper(matrix, dp, r, c-1, w, h, matrix[r][c]));
        dp[r][c] = res + 1;
        return dp[r][c];
    }
}
