/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to 
 * the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}