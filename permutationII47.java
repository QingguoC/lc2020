class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            dfs(nums, used, res, new ArrayList(),i);
        }
            
        return res;
    }
    private void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> path, int curr){
        if(curr>=nums.length||path.size()>=nums.length||used[curr]) return;
        path.add(nums[curr]);
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        used[curr] = true;
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                
                dfs(nums, used, res, path, i);
                
            }
        }
        used[curr] = false;
        path.remove(path.size()-1);
        
    }
}

//dfs trick to avoid duplicate
