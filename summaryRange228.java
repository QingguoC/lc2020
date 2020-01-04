class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        int l = 0, r = 0;
        while(r < nums.length){
            if(r == nums.length-1 || nums[r+1]-1 > nums[r]){
                if(l == r){
                    res.add(""+nums[r]);
                    
                }else{
                    res.add(nums[l]+"->"+nums[r]);
                }
                r++;
                l = r;
            } else{
                r++;
            }
        }
        return res;
    }
}

//two pointers to loop once
