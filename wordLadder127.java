class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return 0;
        HashSet<String> dict = new HashSet();
        for(String s: wordList) {
            dict.add(s);
        }
        if(!dict.contains(endWord)) return 0;
        int res = 0;
        Queue<String> q = new LinkedList(), newQ;
        
        q.add(beginWord);
        while(!q.isEmpty()){
            res++;
            newQ = new LinkedList();
            for(String s: q){
                for(int i = 0; i < s.length(); i++){
                    for(int j = 0; j < 26; j++){
                        if(s.charAt(i) - 'a' != j){
                           String newS = s.substring(0,i) + (char)('a' + j) + s.substring(i+1);
                            if(dict.contains(newS)){
                                newQ.add(newS);
                                dict.remove(newS);
                                if(newS.equals(endWord) ) return res+1;
                            }
                        }
                         
                    }
                }
            }
            
            q = newQ;
        }
        return 0;
    }
}

// bfs (char) and equals
