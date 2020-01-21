class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null ) return true;
        if(s == null || p == null) return false;
        if(s.length() == 0 && p.length() == 0 ) return true;
        // char[] sArr = s.toCharArray();
        // char[] pArr = p.toCharArray();
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        // for(int i = 2; i <= slen; i+=2){
        //     dp[i][0] = s.charAt(i-1) == '*' ? true: false;
        // }
        for(int i = 2; i <= plen; i+=2){
            dp[0][i] = p.charAt(i-1) == '*' &&  dp[0][i-2] ? true: false;
        }
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                if(p.charAt(j-1) == '*'){
                    if(j == 1) dp[i][j] = false;
                    else if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i-1][j] || dp[i][j-2] || dp[i][j-1];
                    }
                }
                else if(s.charAt(i-1) == p.charAt(j-1) ||  p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } 
            }
        }
        return dp[slen][plen];
    }
}

//dp
