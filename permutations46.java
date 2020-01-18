class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1) {
            List<Integer> one = new ArrayList();
            one.add(nums[0]);
            res.add(one);
            return res;
        }
        for(int i = 0; i < nums.length; i++){
            int m = 0;
            int[] newNum = new int[nums.length-1];
            
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    newNum[m++] = nums[j];
                }
            }
            
            for(List<Integer> nextL: permute(newNum)){
                List<Integer> one = new ArrayList();
                one.add(nums[i]);
                for(int n: nextL){
                    one.add(n);
                }
                res.add(one);
            }
            
            
        }
        return res;
    }
}
//recursion seems slow
