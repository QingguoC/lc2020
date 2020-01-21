/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return ""+root.val+" " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 || data.equals("#")) return null;
        Queue<String> q = new LinkedList();
        for(String s: data.split(" ")){
            q.offer(s);
        }
        return helper(q);
    }
    private TreeNode helper(Queue<String> q){
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals("#")) return null;
        int val = Integer.parseInt(s);
        TreeNode root = new TreeNode(val);
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
