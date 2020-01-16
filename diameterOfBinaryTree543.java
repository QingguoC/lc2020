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
    int diam;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        diam = 0;
        height(root);
        return diam;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        diam = Math.max(diam, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}

// utilize height function and meanwhile track diameter
