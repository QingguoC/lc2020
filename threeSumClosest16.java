class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE, res = 0, target2 = 0;
        int l = 0, r = 0, tmpSum = 0;
        for(int i = 0; i < nums.length -2; i++){
            target2 = target - nums[i];
            l = i + 1;
            r = nums.length - 1;
            while(l < r){
                tmpSum = nums[l] + nums[r];
                if(tmpSum == target2) return target;
                if(tmpSum < target2){
                    if(target2 - tmpSum < minDiff){
                        res = tmpSum + nums[i];
                        minDiff = target2 - tmpSum;
                    }
                    l++;
                } else{
                    if(tmpSum - target2 < minDiff){
                        res = tmpSum + nums[i];
                        minDiff = tmpSum - target2;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}

