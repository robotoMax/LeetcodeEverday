/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
 * you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 * 
 * Example 1: 
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *       2
 *      /
 *     4
 * and
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 */
import java.util.*;
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, new HashMap<>());
        return res;
    }
    public String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return "#";
        String serial = root.val + "," + helper(root.left, res, map) + "," + helper(root.right, res, map);
        if (map.getOrDefault(serial, 0) == 1) res.add(root);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}