class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while(l+1 < r){
            if(nums[l] == target) return l;
            if(nums[r] == target) return r;
            int m = (l+r)/2;
            if(nums[m] == target) return m;
            if(nums[r] > nums[l]){
                if(nums[m] > target){
                    
                    r = m - 1;
                    
                } else{
                    l = m + 1;    
                }
            } else{
                if(nums[m] > nums[l]){
                    if(nums[m] < target){
                    
                        l = m + 1;
                    
                    } else{
                        if(nums[l] < target){
                        r = m -1;
                        }
                        else l = m + 1;    
                    }
                } else{
                    if(nums[m] < target){
                        if(nums[r] > target){
                            l = m + 1;
                        }
                        else r = m -1;
                    
                    } else{
                        
                        r = m -1;
                         
                    }
                }
                
            }
            
        }
        if( nums[l] == target) return l;
        if(nums[r] == target) return r;
        return -1;
    }
}
//quite complex for different scenario
