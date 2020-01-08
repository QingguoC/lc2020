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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList(), newQ;
        q.add(root);
        while(!q.isEmpty()){
            newQ = new LinkedList();
            while(!q.isEmpty()){
                TreeNode t = q.poll();
                if(t.left != null){
                    newQ.add(t.left);
                }
                if(t.right != null){
                    newQ.add(t.right);
                }
                if(q.isEmpty()){
                    res.add(t.val);
                }
            }
            q = newQ;
        }
        return res;
    }
}
//typical bfs
