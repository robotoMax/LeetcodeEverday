/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last 
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = getHeight(root);
        return getHeight(root.right) == h - 1 ? ((1 << h - 1) + countNodes(root.right)) : ((1 << h - 2) + countNodes(root.left));
    }
    // must use this. cannot use the second way to calculate the tree height
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return getHeight(root.left) + 1;
    }
    public int getHeight1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}