class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 1;
        
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }
        if(i != 0){
            int toMove = nums[i-1];
            int j = i;
            while(j<nums.length && nums[j]>toMove){
                j++;
            }
            nums[i-1] = nums[j-1];
            nums[j-1] = toMove;
        }
        int l = i, r = nums.length-1;
        while(l < r){
            swap(nums, l++, r--);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//back search the first descending index, swap with right larger one, and sort right numbers in order to keep minimum
