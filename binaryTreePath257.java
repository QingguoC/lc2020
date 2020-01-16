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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if(root == null){
            return res;
        }
        dfs(root, res, "");
        return res;
    }
    private void dfs(TreeNode root, List<String> res, String path){
        if(root == null) {
            
            return;
        }
        if(root.left == null && root.right == null){
            res.add(path+root.val);
            return;
        }
        
            dfs(root.left, res, path+root.val+"->");
            
        
        
            dfs(root.right, res, path+root.val+"->");
            
        
        
    }
}
//dfs
