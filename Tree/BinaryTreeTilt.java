/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, return the tilt of the whole tree.
 * 
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree 
 * node values and the sum of all right subtree node values. Null node has tilt 0.
 * 
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * 
 * Example:
 * Input: 
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation: 
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 */
public class BinaryTreeTilt {
    int res = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}