class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++){
            output[i] = output[i-1] * nums[i-1];
        }
        int tmp = 1;
        for(int i = nums.length-2; i >= 0; i--){
            tmp = tmp * nums[i+1];
            output[i] = output[i] * tmp;
        }
        return output;
    }
}
// loop forward to product previous without self, then cache back product in back order and then product prev and back products. 
