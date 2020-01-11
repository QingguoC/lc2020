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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList(), newQ;
        q.offer(root);
        while(!q.isEmpty()){
            newQ = new LinkedList();
            List<Integer> layer = new ArrayList();
            for(TreeNode n: q){
                layer.add(n.val);
                if(n.left!=null){
                    newQ.offer(n.left);
                }
                if(n.right!=null){
                    newQ.offer(n.right);
                }
            }
            res.add(layer);
            q = newQ;
        }
        int l = 0, r = res.size()-1;
        while(l < r){
            List<Integer> tmp = res.get(r);
            res.set(r,res.get(l));
            res.set(l, tmp);
            l++;
            r--;
        }
        return res;
    }
}
//bfs
