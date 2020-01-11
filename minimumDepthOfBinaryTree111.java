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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList(), newQ;
        q.offer(root);
        while(!q.isEmpty()){
            depth++;
            newQ = new LinkedList();
            for(TreeNode n: q){
                if(n.left == null && n.right == null) return depth;
                if(n.left != null){
                    newQ.offer(n.left);
                }
                if(n.right != null){
                    newQ.offer(n.right);
                }
                
            }
            q = newQ;
        }
        return depth;
    }
}

//bfs
