/**
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {
    public int solution(TreeNode root) {
        if (root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        return Math.max(left, right) + 1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}