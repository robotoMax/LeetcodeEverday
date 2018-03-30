import java.util.*;
public class BinaryTreePreorderIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BinaryTreePreorderIterator(TreeNode root) {
        if (root != null) stack.push(root);
    }

    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}