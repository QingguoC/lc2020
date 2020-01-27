class Solution {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = nums.length - 1;
        while(w <= b){
            if(nums[w] == 0) {
                swap(nums, w, r);
                w++;
                r++;
            } else if(nums[w] == 1){
                w++;
            } else{
                swap(nums, w, b);
                b--;
            }
        }
        
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//one pass
