class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        res.add(new ArrayList(path));
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            dfs(nums, res, path, i);
        }
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int curr){
        if(curr >= nums.length){
            return;
        }
        path.add(nums[curr]);
        res.add(new ArrayList(path));
        for(int j = curr+1; j < nums.length; j++){
            dfs(nums, res, path, j);
        }
        
        path.remove(path.size()-1);
    }
}

//two for loop dfs
