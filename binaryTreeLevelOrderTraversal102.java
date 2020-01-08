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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList(), newQ;
        q.add(root);
        while(!q.isEmpty()){
            newQ = new LinkedList();
            List<Integer> currLayer = new ArrayList();
            for(TreeNode node: q){
                currLayer.add(node.val);
                if(node.left!=null){
                    newQ.add(node.left);
                }
                if(node.right!=null){
                    newQ.add(node.right);
                }
            }
            q = newQ;
            res.add(currLayer);
        }
        return res;
    }
}
//typical bfs
