import java.util.Random;
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
    public static TreeNode createTree(int num, boolean BST) {
        TreeNode root = new TreeNode(num);
        if (BST) {
            root.left = new TreeNode(num - 3);
            root.right = new TreeNode(num + 3);
            root.left.left = new TreeNode(num - 4);
            root.left.right = new TreeNode(num - 2);
            root.right.left = new TreeNode(num + 2);
            root.right.right = new TreeNode(num + 4);
            root.left.left.left = new TreeNode(num - 6);
        }
        else {
            Random rand = new Random();
            root.left = new TreeNode(rand.nextInt(10));
            root.right = new TreeNode(rand.nextInt(10));
            root.left.left = new TreeNode(rand.nextInt(5));
            root.right.right = new TreeNode(rand.nextInt(21));
            root.left.right = new TreeNode(rand.nextInt(19));
            root.right.left = new TreeNode(rand.nextInt(30));
        }
        return root;
    }
}