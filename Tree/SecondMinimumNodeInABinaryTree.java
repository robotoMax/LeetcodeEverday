/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
 * then this node's value is the smaller value among its two sub-nodes.
 * 
 * Given such a binary tree, you need to output the second minimum value in the set made of 
 * all the nodes' value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * Example 1:
 * Input: 
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * 
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input: 
 *     2
 *    / \
 *   2   2
 * 
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinimumNodeInABinaryTree {
    int res = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.val == root.left.val) {
            helper(root.left);
        }
        if (root.right != null && root.val == root.right.val) {
            helper(root.right);
        }
        if (root.left != null && root.val != root.left.val) {
            res = Math.min(res, root.left.val);
        }
        if (root.right != null && root.val != root.right.val) {
            res = Math.min(res, root.right.val);
        }
        return;
    }
}