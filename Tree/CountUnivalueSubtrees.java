/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 * return 4.
 */
public class CountUnivalueSubtrees {
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left != null) {
                if (root.val != root.left.val) return false;
            }
            if (root.right != null) {
                if (root.val != root.right.val) return false;
            }
            res++;
        }
        return left && right;
    }
}