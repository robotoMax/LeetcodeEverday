/**
 * 
 * Date: 03/30/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, sum, res, new ArrayList<>());
        return res;
    }
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        temp.add(root.val);
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (root.left != null) {
            helper(root.left, sum - root.val, res, temp);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}