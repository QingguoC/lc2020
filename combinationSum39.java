class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates == null || candidates.length == 0 || target <= 0) return res;
        for(int i = 0; i < candidates.length; i++){
            helper(candidates, i, target, res, new ArrayList());
        }
        return res;
    }
    private void helper(int[] candidates, int curr, int target, List<List<Integer>> res, List<Integer> path){
        if(curr >= candidates.length || target < candidates[curr]) return;
        
        if(target == candidates[curr]){
            path.add(target);
            res.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(candidates[curr]);
        
        for(int i = curr; i < candidates.length; i++){
            
            helper(candidates, i, target-candidates[curr], res, path);
            
        }
        path.remove(path.size()-1);
        
    }
}

// dfs remember to remove last path element before return
