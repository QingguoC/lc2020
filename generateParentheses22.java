class Solution {
    public List<String> generateParenthesis(int n) {
        //dp[n+1] = (for i in 0 to n dp[i]) + dp[n-i]
        List<String>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList();
        dp[0].add("");
        if(n == 0) return dp[0];
        dp[1] = new ArrayList();
        dp[1].add("()");
        if(n == 1) return dp[1];
        for(int i = 2; i < n+1; i++){
            dp[i] = new ArrayList();
            for(int j = 0; j < i; j++){
                
                for(String s1: dp[j]){
                    for(String s2: dp[i-j-1]){
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(s1);
                        sb.append(")");
                        sb.append(s2);
                        dp[i].add(sb.toString());
                    }
                    
                }
            }
        }
        return dp[n];
        
        
    }
}
//dp, dp[n+1] loop dp[i] in (), n-i at left 
