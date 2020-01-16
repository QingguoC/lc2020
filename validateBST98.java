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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    private boolean helper(TreeNode root){
        if(root == null) return true;
        boolean ret = helper(root.left);
        ret = ret && (prev!=null? prev.val < root.val: true);
        prev = root;
        return ret && helper(root.right);
    }
}
//recursion
