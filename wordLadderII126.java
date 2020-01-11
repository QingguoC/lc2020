class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet();
        for(String s: wordList){
            dict.add(s);
        }
        List<List<String>> res = new LinkedList();
        if(!dict.contains(endWord)) return res;
        Queue<String> q = new LinkedList(), newQ;
        HashMap<String, HashSet<String>> map = new HashMap();
        q.add(beginWord);
        while(!q.isEmpty()){
            newQ = new LinkedList();
            for(String curr: q){
                if(curr.equals(endWord)) break;
                for(int i = 0; i < curr.length(); i++){
                    for(int j = 0; j < 26; j++){
                        if(curr.charAt(i) - 'a' != j){
                            String newStr = curr.substring(0,i) + (char) ('a' + j) + curr.substring(i+1);
                            if(dict.contains(newStr)){
                                if(!map.containsKey(newStr)){
                                    map.put(newStr, new HashSet());
                                }
                                map.get(newStr).add(curr);
                                
                                newQ.add(newStr);
                                
                            }
                        }
                    }
                }
            }
            dict.removeAll(newQ);
            q = newQ;
        }
        if(dict.contains(endWord)) return res;
        dfs(endWord, beginWord, map, res, new LinkedList());
        return res;
    }
    private void dfs(String currWord, String beginWord, HashMap<String, HashSet<String>> map, List<List<String>> res, List<String> currList){
        currList.add(0,currWord);
        if(currWord == beginWord) {
            res.add(currList);
            return;
        }
        for(String next: map.get(currWord)){
            dfs(next, beginWord, map, res, new LinkedList(currList));
        }
        currList.remove(0);
    }
}
//one bfs, then dfs to track back 
