class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0) return new int[0][2];
        int currA = 0, currB = 0;
        List<int[]> ol = new ArrayList();
        while(currA < A.length && currB < B.length){
            if(A[currA][0] > B[currB][1]){
                currB++;
            } else if(A[currA][1] < B[currB][0]){
                currA++;
            } else if(A[currA][1] >= B[currB][1]){
                ol.add(new int[]{Math.max(A[currA][0], B[currB][0]), B[currB][1]});
                currB++;
            } else{
                ol.add(new int[]{Math.max(A[currA][0], B[currB][0]), A[currA][1]});
                currA++;
            }
            
        }
        int[][] res = new int[ol.size()][2];
        for(int i = 0; i < ol.size(); i++){
            res[i] = ol.get(i);
        }
        return res;
    }
}

