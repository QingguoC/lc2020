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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = pathSumFromRoot(root, sum);
        return (res == -1? 0:res) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int pathSumFromRoot(TreeNode root, int sum){
        if(root == null) return -1;
        int res = 0;
        if(root.val == sum) res++;
        int left = pathSumFromRoot(root.left, sum-root.val);
        int right = pathSumFromRoot(root.right, sum-root.val);
        if(left != -1) res += left;
        if(right != -1) res += right;
        return res;
    }
}

//findNumfromroot helper 
