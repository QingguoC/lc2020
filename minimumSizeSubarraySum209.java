class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(s <= 0) return 0;
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        for(int i = 1; i < nums.length+1; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        int l = 0, r = 1, minLen = nums.length + 1; 
        while(r < nums.length+1 && l < r){
            if(sums[r] < s){
                r++;
            }else{
                if(sums[r]-sums[l] >= s){
                    minLen = Math.min(minLen, r-l);
                    l++;
                } else{
                    r++;
                }
            }
        }
        return minLen == nums.length + 1? 0:minLen;
    }
}
