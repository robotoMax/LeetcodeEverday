/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the 
 * parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * For example,
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *    2
 *     \
 *      3
 *     / 
 *    2    
 *   / 
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val, 0);
        return res;
    }
    public void helper(TreeNode root, int next, int cur) {
        if (root == null) return;
        if (root.val == next) {
            cur++;
            res = Math.max(res, cur);
        }
        else cur = 1;
        helper(root.left, root.val + 1, cur);
        helper(root.right, root.val + 1, cur);
        return;
    }
}