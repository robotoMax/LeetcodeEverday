/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * You need to find the largest value in each row of a binary tree.
 * Example:
 * Input: 
 * 
 *           1
 *          / \
 *         3   2
 *        / \   \  
 *       5   3   9 
 * Output: [1, 3, 9]
 */
import java.util.*;
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        if (root.val > res.get(level)) {
            res.set(level, root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}