/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original 
 * BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 * 
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
/**
 * backword inorder traversal
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}