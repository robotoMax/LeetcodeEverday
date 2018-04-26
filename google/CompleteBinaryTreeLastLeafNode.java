/**
 * 
 * Date: 04/13/2018
 * Created By: Shuai Liu
 * 
 * Given a complete binary tree, return the rightmost node of the tree
 */
public class CompleteBinaryTreeLastLeafNode {
    public TreeNode solution(TreeNode root) {
        TreeNode res = null;
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (rightHeight == leftHeight) {
            return solution(root.right);
        }
        else {
            return solution(root.left);     
        }
    }
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return getHeight(root.left) + 1;
    }
    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);
        root0.left = root1;
        root0.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        CompleteBinaryTreeLastLeafNode c = new CompleteBinaryTreeLastLeafNode();
        System.out.println(c.solution(root0).val);
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {this.val = val;}
}