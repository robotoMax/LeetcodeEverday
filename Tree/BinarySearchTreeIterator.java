/**
 * 
 * Date: 03/27/2018
 * Created By: Shuai Liu
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the 
 * root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height 
 * of the tree.
 */
import java.util.*;
public class BinarySearchTreeInorderIterator {
    
    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeInorderIterator(TreeNode root) {
        pushAllLeftNode(root);
    }

    public void pushAllLeftNode(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        int res = 0;
        if (hasNext()) {
            TreeNode cur = stack.pop();
            res = cur.val;
            pushAllLeftNode(cur.right);
        }
        return res;
    }

}