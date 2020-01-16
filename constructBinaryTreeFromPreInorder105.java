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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length ) return null;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, map, 0, preorder.length-1, 0, preorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int pStart, int pEnd, int iStart, int iEnd){
        if(pStart > pEnd || iStart > iEnd) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int iRoot = map.get(preorder[pStart]);
        int numOfLeft =  iRoot - iStart; 
        root.left = helper(preorder, inorder, map, pStart+1, pStart+numOfLeft, iStart, iRoot - 1);
        root.right = helper(preorder, inorder, map, pStart+numOfLeft+1, pEnd, iRoot+1, iEnd);
        return root;
    }
    
    
}
//prorder at first, then find root in inorder
