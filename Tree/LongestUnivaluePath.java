/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. 
 * This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Example 1:
 * 
 * Input:
 * 
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 * 
 * 2
 * Example 2:
 * 
 * Input:
 * 
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 * 
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    int res = 0;
    public int solution(TreeNode root) {
        if (root == null) return res;
        helper(root, root.val);
        return res;
    }
    public int helper(TreeNode root, int val) {
        if (root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        res = Math.max(res, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        else return 0;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(10, false);
        LongestUnivaluePath l = new LongestUnivaluePath();
        System.out.println(l.solution(root));
    }
}