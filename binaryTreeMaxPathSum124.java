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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(0,helper(root.left));
        int rightMax = Math.max(0,helper(root.right));
        maxSum = Math.max(maxSum, leftMax + root.val + rightMax);
        return Math.max(leftMax + root.val, root.val + rightMax);
        
    }
}

//helper to return max side with root val, but track maxSum meanwhile
