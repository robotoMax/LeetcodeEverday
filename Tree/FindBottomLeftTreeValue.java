/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * 
 * Output:
 * 1
 * Example 2: 
 * Input:
 * 
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue {
    int res = 0;
    int height = 0;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1);
        return res;
    }
    public void helper(TreeNode root, int d) {
        if (root == null) return;
        if (d > height) {
            res = root.val;
            height = d;
        }
        helper(root.left, d + 1);
        helper(root.right, d + 1);
    }
}