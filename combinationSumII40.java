class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>  res = new ArrayList();
        if(candidates == null || candidates.length == 0 ) return res;
        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++){
            if(i > 0  && candidates[i] == candidates[i-1]) continue;
            helper(candidates, target, res, new ArrayList(), i);
        }
        
        return res;
    }
    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int curr){
        if(curr >= candidates.length || target < candidates[curr]) return;
        if(target == candidates[curr] ){
            path.add(target);
            res.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(candidates[curr]);
        for(int i = curr+1; i < candidates.length; i++){
           if(i > curr+1  && candidates[i] == candidates[i-1]) continue;
            helper(candidates, target-candidates[curr], res, path, i);
        }
        path.remove(path.size()-1);
    }
}
// dfs sort array to avoid repeat in two for looops
