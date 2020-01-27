class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        HashMap<Character, Integer> required = new HashMap();
        for(char c: t.toCharArray()){
            required.put(c, required.getOrDefault(c, 0)+1);
        }
        int cnt = 0, minLen = s.length()+1, minLeft = 0, l = 0;
        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            if(required.containsKey(curr)){
                required.put(curr, required.get(curr)-1);
                if(required.get(curr) >= 0) {
                    cnt++;
                }
                while(cnt == t.length()){
                    if(minLen > r-l+1){
                        minLen = r-l+1;
                        minLeft = l;
                    }
                    
                    if(required.containsKey(s.charAt(l))){
                        
                        required.put(s.charAt(l), required.get(s.charAt(l))+1);
                        if(required.get(s.charAt(l)) > 0) cnt--;
                    }
                    l++;
                }
            }
        }
        if(minLen > s.length()) return "";
        return s.substring(minLeft, minLeft+minLen);
    }
}

