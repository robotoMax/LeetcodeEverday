/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * 
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * 
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 *       6
 *     /   \
 *    3     5
 *     \    / 
 *      2  0   
 *        \
 *         1
 * 
 */

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int i, int j) {
        if (i > j) return null;
        int index = getMax(nums, i, j);
        int max = nums[index];
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, i, index - 1);
        root.right = helper(nums, index + 1, j);
        return root;
    }
    public int getMax(int[] nums, int i, int j) {
        int res = Integer.MIN_VALUE;
        int index = i;
        for (int p = i; p <= j; p++) {
            if (nums[p] > res) {
                res = nums[p];
                index = p;
            }
        }
        return index;
    }
}