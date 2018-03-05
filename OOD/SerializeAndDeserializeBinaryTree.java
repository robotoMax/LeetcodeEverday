/*
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection 
 * link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string 
 * and this string can be deserialized to the original tree structure.
*/
public class SerializeAndDeserializeBinaryTree {

   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
       if (root == null) return "";
       StringBuilder sb = new StringBuilder();
       helper(root, sb);
       return sb.toString();
   }
   
   public void helper(TreeNode root, StringBuilder sb) {
       if (root == null) {
           sb.append("#").append(",");
           return;
       }
       sb.append(root.val).append(",");
       helper(root.left, sb);
       helper(root.right, sb);
       return;
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
       if (data == null || data.length() == 0) return null;
       String[] strs = data.split(",");
       Deque<String> queue = new LinkedList<>();
       queue.addAll(Arrays.asList(strs));
       return helper(queue);
   }
   public TreeNode helper(Deque<String> queue) {
       String str = queue.poll();
       if (str.equals("#")) return null;
       else {
           TreeNode root = new TreeNode(Integer.parseInt(str));
           root.left = helper(queue);
           root.right = helper(queue);
           return root;
       }
   }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));