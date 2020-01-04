class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            HashSet<Integer> used = new HashSet();
            HashSet<Integer> seen = new HashSet();
            for(int j = i+1; j<nums.length; j++){
                if(seen.contains(target - nums[j]) && !used.contains(target - nums[j])){
                  
                    res.add(Arrays.asList(nums[i],target - nums[j], nums[j] ));
                    seen.add(nums[j]);
                    used.add(nums[j]);
                    used.add(target - nums[j]);
                }else{
                    seen.add(nums[j]);
                }
            }
            
            
        }
        return res;
        
    }
}
//seen and used to record and avoid repeat target
