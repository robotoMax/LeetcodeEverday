/**
 * Date: 09/02/2018
 * Created By: Shuai Liu
 * 
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the 
 * root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * 
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return 
 * any of them.
 * 
 * For example, 
 * 
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 * 
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *          5
 *        /   \
 *       2     7
 *     / \   
 *     1   3
 *          \
 *           4
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return root;
        TreeNode pre = null;
        TreeNode dum = root;
        while (root != null) {
            pre = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        if (pre.val > val) pre.left = new TreeNode(val);
        else if (pre.val < val) pre.right = new TreeNode(val);
        return dum;
    }
}