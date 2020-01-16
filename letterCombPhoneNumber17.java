class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        List<String> res = new ArrayList();
        dfs(digits, map, 0, new StringBuilder(), res);
        return res;
        
    }
    private void dfs(String digits, Map<Character, List<Character>> map, int curr, StringBuilder sb, List<String> res){
        if(curr == digits.length()){
            if(sb.length()>0)
            res.add(sb.toString());
            return;
        }
        char currC = digits.charAt(curr);
        if(map.containsKey(currC)){
            for(char c: map.get(currC)){
                sb.append(c);
                dfs(digits, map, curr+1, sb, res);
                sb.deleteCharAt(sb.length()-1);
            }
        } else{
            dfs(digits, map, curr+1, sb, res);
        }
    }
}
//dfs
