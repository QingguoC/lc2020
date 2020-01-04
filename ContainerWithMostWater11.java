class Solution {
    public int maxArea(int[] height) {
        int res = 0, curr = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            if(height[l] < height[r]){
                curr = height[l] * (r - l);
                l++;
            } else{
                curr = height[r] * (r - l);
                r--;
            }
            if(curr > res){
                res = curr;
            }
        }
        return res;
    }
}
//move index with shorter wall
