/**
 * Given an array of binary tree node. Can these node construct a binary tree?
 */
import java.util.*;
public class CanBuildABinaryTree {
    public boolean solution(TreeNode[] nodes) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                if (parent.containsKey(node.left)) return false;
                parent.put(node.left, node);
            }
            if (node.right != null) {
                if (parent.containsKey(node.right)) return false;
                parent.put(node.right, node);   
            }
        }
        TreeNode root = null;
        for (TreeNode node : nodes) {
            if (!parent.containsKey(node)) {
                if (root == null) root = node;
                else return false;
            }
        }
        System.out.println(root.val);
        Set<TreeNode> visited = new HashSet<>();
        return !hasCircle(root, visited); // i think we don't need to check if there is a circle there.
    }
    public boolean hasCircle(TreeNode root, Set<TreeNode> visited) {
        if (visited.contains(root)) return true;
        if (root == null) return false;
        visited.add(root);
        if (hasCircle(root.left, visited) || hasCircle(root.right, visited)) return true;
        return false;
    }
    public static void main(String[] args) {
        CanBuildABinaryTree c = new CanBuildABinaryTree();
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root5.right = root6;
        root2.right = root6;
        TreeNode[] nodes = {root, root1, root2, root3, root4, root5, root6};
        System.out.println(c.solution(nodes));
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}