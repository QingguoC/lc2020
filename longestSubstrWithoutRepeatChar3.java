class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, l = 0, r = 0;
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap();
        while(r < s.length()){
           char currR = s.charAt(r);
            if(map.containsKey(currR)){
                l = Math.max(l, map.get(currR)+1);
            }
            map.put(currR, r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
        
    }
}




//two pointers
