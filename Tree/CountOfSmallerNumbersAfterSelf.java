/**
 * 
 * Date: 03/30/2018
 * Created By: Shuai Liu
 * 
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where 
 * counts[i] is the number of smaller elements to the right of nums[i].
 * 
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
import java.util.*;
public class CountOfSmallerNumbersAfterSelf {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int leftNodeCount;
        public TreeNode(int val, int leftNodeCount) {
            this.val = val;
            this.leftNodeCount = leftNodeCount;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = helper(root, i, nums[i], res, 0);
        }
        return Arrays.asList(res);
    }
    public TreeNode helper(TreeNode root, int index, int cur, Integer[] res, int curLeft) {
        if (root == null) {
            res[index] = curLeft;
            return new TreeNode(cur, 0);
        }
        if (root.val > cur) {
            root.leftNodeCount++;
            root.left = helper(root.left, index, cur, res, curLeft);
        }
        else {
            root.right = helper(root.right, index, cur, res, curLeft + root.leftNodeCount + (cur == root.val ? 0 : 1));
        }
        return root;
    }
}