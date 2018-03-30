import java.util.*;
public class BinaryTreePostOrderIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BinaryTreePostOrderIterator(TreeNode root) {
        findNextNode(root);
    }

    public void findNextNode(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    public int next() {
        if (!hasNext()) throw new NoSuchElementException("No other node.");
        TreeNode cur = stack.pop();
        TreeNode top = stack.peek();
        if (top.left == cur) {
            findNextNode(top.right);
        }
        return cur.val;
    }

    public boolean hasNext() {
        return !s2.isEmpty();
    }

}