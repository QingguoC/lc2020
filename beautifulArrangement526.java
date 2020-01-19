class Solution {
    int num = 0;
    public int countArrangement(int N) {
        int[] nums = new int[N];
        helper(N, 1, nums);
        return num;
    }
    private void helper(int N, int pos, int[] nums){
        if(pos > N) {
            num++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(nums[i-1] == 0){
                if(pos % i == 0 || i % pos == 0){
                    nums[i-1] = 1;
                    helper(N, pos+1, nums);
                    nums[i-1] = 0;
                }
            }
        }
    }
}

