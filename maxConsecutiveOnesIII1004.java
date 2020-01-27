class Solution {
    public int longestOnes(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int maxLen = 0, l = 0, fill = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0) {
                fill++;
            }
            while(fill > K){
                if(A[l] == 0) fill--;
                l++;
            }
            maxLen = Math.max(maxLen, i-l+1);
        }
            
        return maxLen;
    }
}



