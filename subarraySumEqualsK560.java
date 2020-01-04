class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 1){
            if(nums[0] == k) return 1;
            return 0;
        }
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(i == 0 ) {
                    if(nums[j] == k)
                    res++;
                } else if(nums[j] - nums[i-1] == k){
                    res++;
                } 
            }
        }
        return res;
    }
}

// accumulate sum and two for loops
