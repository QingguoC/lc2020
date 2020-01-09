/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap();
        map.put(node, new Node(node.val, new ArrayList()));
        Queue<Node> q = new LinkedList();
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            
                Node cloned = map.get(curr);
                
                for(Node nei: curr.neighbors){
                    if(!map.containsKey(nei)){
                        q.add(nei);
                        map.put(nei, new Node(nei.val, new ArrayList()));
                        
                    }
                    cloned.neighbors.add(map.get(nei));
                }
            
            
        }
        return map.get(node);
    }
}

// map key oldnode value newnode, clone neighbors when bfs loop neighbors, return map(node)
