/**
 * 
 * Date: 03/16/2018
 * Created By: Shuai Liu
 * 
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *     2
 *    / \
 *   1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *     1
 *    / \
 *   2   3
 * Binary tree [1,2,3], return false.
 */
/**
 * simialar with recover binary search tree. Both them are using pre as instance variable to do the inorder traversal;
 */
public class ValidateBinarySearchTree {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null) {
            if (pre.val >= root.val) return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        return  helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}