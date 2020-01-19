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
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(prev != null){
            prev.right = root;
        }
        prev = root;
        TreeNode right = root.right;
        flatten(root.left);
        root.left = null;
        flatten(right);
    }
}
//recursion
