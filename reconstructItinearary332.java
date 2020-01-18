class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList();
        Map<String, PriorityQueue<String>> adjs = new HashMap();
        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!adjs.containsKey(from)){
                adjs.put(from, new PriorityQueue());
            }
            PriorityQueue<String> q = adjs.get(from);
            q.add(to);              
        }
        dfs(adjs, res, "JFK");
        return res;
    }
    private void dfs(Map<String, PriorityQueue<String>> adjs, List<String> res, String from){
        // if(!adjs.containsKey(from)) return;
        PriorityQueue<String> q = adjs.get(from);
        while(q !=null && !q.isEmpty()){
            dfs(adjs, res, q.poll());
        }
        res.add(0,from);
    }
}
//dfs
