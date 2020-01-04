class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] eitherCnt = new int[6];
        int[] aOnlyCnt = new int[6];
        int[] bOnlyCnt = new int[6];
        for(int i = 0; i < A.length; i++){
            
            eitherCnt[A[i]-1]++;
            if(A[i] != B[i]){
                eitherCnt[B[i]-1]++;
                aOnlyCnt[A[i]-1]++;
                bOnlyCnt[B[i]-1]++;
            }
                
        }
        for(int i = 0; i < 6; i++){
            if(eitherCnt[i] == A.length){
                return Math.min(aOnlyCnt[i], bOnlyCnt[i]);
            }
        }
        return -1;
    }
}
// three arrays for or, a only, b only cnts, or array must have A.length if doable. 
