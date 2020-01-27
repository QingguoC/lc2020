class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null) return 0;
        if(s.length() < 3) return s.length();
        int l = 0, r = 1, ll = 0, rl = r, res = 2;
        char[] sArr = s.toCharArray();
        while(r < sArr.length && sArr[r] == sArr[l]){
            r++;
            ll++;
        }
        if(r == sArr.length) return r;
        rl = r;
        res = r - l + 1;
        for(int i = 2; i < sArr.length; i++){
            if(sArr[i] == sArr[l]){
                ll = i;
                continue;
            }
            if(sArr[i] == sArr[r]){
                rl = i;
                continue;
            }
            res = Math.max(res, i-l);
            if(ll < rl){
                l = ll+1;
                ll = rl;
            } else{
                l = rl+1;
            }
            r = i;
            rl = i;
        }
        res = Math.max(res, sArr.length-l);
        return res;
        
    }
}

