class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, 4, 0);
    }
    private List<List<Integer>> helper(int[] nums, int target, int k, int curr){
        int n = nums.length;
        List<List<Integer>> res = new LinkedList();
        if(curr >= n) return res;
        if(k == 2){
            int l = curr, r = n - 1;
            while(l < r){
                if(nums[l] + nums[r] == target){
                    List<Integer> pair = new LinkedList();
                    pair.add(nums[l]);
                    pair.add(nums[r]);
                    res.add(pair);
                    while(l < r && nums[l+1] == nums[l]){
                        l++;
                    }
                    while(l < r && nums[r-1] == nums[r]){
                        r--;
                    }
                    l++;
                    r--;
                } else if(nums[l] + nums[r] < target){
                    l++;
                } else{
                    r--;
                }
            }
            
        } else{
            for(int i = curr; i < n-k+1; i++){
                if(i > curr && nums[i] == nums[i-1]) continue;
                List<List<Integer>> path = helper(nums, target - nums[i], k-1, i+1);
                for(List<Integer> list: path){
                    list.add(0, nums[i]);
                }
                res.addAll(path);
            }
        }
        return res;
        
    }
}

//generalized ksum, two pointers and recursion
