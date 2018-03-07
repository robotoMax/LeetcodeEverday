/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree with n nodes, your task is to check if it's possible to 
 * partition the tree to two trees which have the equal sum of values after removing 
 * exactly one edge on the original tree.
 * 
 * Example 1:
 * Input:     
 *     5
 *    / \
 *   10 10
 *     /  \
 *    2   3
 * 
 * Output: True
 * Explanation: 
 *     5
 *    / 
 *   10
 *       
 * Sum: 15
 * 
 *    10
 *   /  \
 *  2    3
 * 
 * Sum: 15
 * Example 2:
 * Input:     
 *     1
 *    / \
 *   2  10
 *     /  \
 *    2   20
 * 
 * Output: False
 * Explanation: You can't split the tree into two trees with equal 
 * sum after removing exactly one edge on the tree.
 * 
 */
import java.util.*;
public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = helper(root, map);
        if (sum == 0) return map.getOrDefault(sum, 0) > 1;
        return (sum % 2 == 0) && map.containsKey(sum / 2);
    }
    public int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int cur = left + right + root.val;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }
}