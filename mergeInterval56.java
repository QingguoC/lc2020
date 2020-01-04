class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals,(x1, x2) -> Integer.compare(x1[0],x2[0]));
        List<List<Integer>> merged = new ArrayList();
        int l = 0, r = 1, currR = intervals[l][1];
        while(r < intervals.length){
            if(currR >= intervals[r][0]){
                currR = Math.max(intervals[r][1], currR);
                r++;
            } else{
                merged.add(Arrays.asList(intervals[l][0], currR));
                l=r;
                currR = intervals[r][1];
                r++;
            }
        }
        merged.add(Arrays.asList(intervals[l][0], currR));
        int[][] res = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++){
            res[i][0] = merged.get(i).get(0);
            res[i][1] = merged.get(i).get(1);
        }
        return res;
    }
}
//sort array by first element, then loop once to merge
