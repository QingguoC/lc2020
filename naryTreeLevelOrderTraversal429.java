/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        Queue<Node> q = new LinkedList(), newQ;
        q.offer(root);
        while(!q.isEmpty()){
            newQ = new LinkedList();
            List<Integer> layer = new LinkedList();
            for(Node node: q){
                layer.add(node.val);
                if(node.children != null && node.children.size()!=0){
                    for(Node child: node.children){
                        if(child != null){
                            newQ.offer(child);
                        }
                    }
                }
            }
            res.add(layer);
            q = newQ;
        }
        return res;
    }
}
//bfs
