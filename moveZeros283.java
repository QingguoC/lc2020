class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int curr = 0;
        for(int i: nums){
            if(i != 0){
                nums[curr++] = i;
            }
        }
        while(curr < nums.length){
            nums[curr++] = 0;
        }
    }
}

