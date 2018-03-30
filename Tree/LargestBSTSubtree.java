/**
 * 
 * Date: 03/29/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with 
 * largest number of nodes in it.
 * 
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *     10
 *     / \
 *    5  15
 *   / \   \ 
 *  1   8   7
 * The Largest BST Subtree in this case is the highlighted one. 
 * The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public int[] helper(TreeNode root) {
        if (root == null) return new int[3];
        int[] temp = new int[3];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if ((left[0] == 0 || (left[0] > 0 && root.val > left[2]))
        && (right[0] == 0 || (right[0] > 0 && root.val < right[1]))) {
            temp[0] = left[0] + right[0] + 1;
            res = Math.max(res, temp[0]);
            temp[1] = left[0] == 0 ? root.val : left[1];
            temp[2] = right[0] == 0 ? root.val : right[2];
        }
        else temp[0] = -1;
        return temp;   
    }
}