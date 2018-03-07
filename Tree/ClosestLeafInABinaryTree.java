/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
 * 
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
 * 
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 * 
 * Example 1:
 * 
 * Input:
 * root = [1, 3, 2], k = 1
 * Diagram of binary tree:
 *           1
 *          / \
 *         3   2
 * 
 * Output: 2 (or 3)
 * 
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 * 
 * Example 2:
 * 
 * Input:
 * root = [1], k = 1
 * Output: 1
 * 
 * Explanation: The nearest leaf node is the root node itself.
 * 
 * Solution: Using DFS to find the node equals to the target value, and adding all the back edge
 * to the map. Then using BFS to search the shortest distance.
 *  
 */
import java.util.*;
public class ClosestLeafInABinaryTree {
    public int solution(TreeNode root, int k) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode startNode = helper(root, k, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) return cur.val;
            if (cur.left != null && visited.add(cur.left)) {
                queue.add(cur.left);
            }
            if (cur.right != null && visited.add(cur.right)) {
                queue.add(cur.right);
            }
            if (map.containsKey(cur) && visited.add(map.get(cur))) {
                queue.add(map.get(cur));
            }
        }
        return -1;
    }
    public TreeNode helper(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root.val == k) return root;
        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = helper(root.left, k, map);
            if (left != null) return left;
        }
        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = helper(root.right, k, map);
            if (right != null) return right;
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(10, true);
        ClosestLeafInABinaryTree c = new ClosestLeafInABinaryTree();
        System.out.println(c.solution(root, 6));
    }
}