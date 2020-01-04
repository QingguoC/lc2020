class Solution {
    public void rotate(int[][] matrix) {
        int n =  matrix.length;
        int u = 0, d = n - 1;
        while(u < d){
            for(int i = 0; i < n; i++){
                swap(matrix, u,i, d, i);
            }
            u++;
            d--;
        }
        for(int r = 0; r < n; r++){
            for(int c = 0; c < r; c++){
                swap(matrix, r,c,c,r);
            }
        }
    }
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
        
    }
}
//upside down and swap symmetric positions
