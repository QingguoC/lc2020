/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList();
        HashMap<Integer, List<Integer>> adjs = new HashMap();
        visit(root, adjs, null);
        int cnt = 0;
        Queue<Integer> q = new LinkedList(), newQ;
        HashSet<Integer> visited = new HashSet();
        q.offer(target.val);
        while(!q.isEmpty()){
            newQ = new LinkedList();
            cnt++;
            if(cnt-1 == K){
                for(int i: q){
                    res.add(i);
                }
               return res;     
            }
            for(int i: q){
                
                visited.add(i);
                if(adjs.containsKey(i)){
                    for(int j: adjs.get(i)){
                        if(!visited.contains(j)){
                            newQ.offer(j);
                        }
                    }
                }
            }
            q = newQ;
        }
        return res;
    }
    private void visit(TreeNode root, HashMap<Integer, List<Integer>> adjs, TreeNode parent){
        //if(root == null) return;
        adjs.put(root.val, new ArrayList());
        if(parent != null) adjs.get(root.val).add(parent.val);
        if(root.left != null) {
            adjs.get(root.val).add(root.left.val);
            visit(root.left, adjs, root);
        }
        if(root.right != null) {
            adjs.get(root.val).add(root.right.val);
            visit(root.right, adjs, root);
        }
    }
}
//graph parent and children, bfs to find res
