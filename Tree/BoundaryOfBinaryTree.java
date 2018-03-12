/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * 
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as 
 * the path from root to the right-most node. If the root doesn't have left subtree or right subtree, 
 * then the root itself is left boundary or right boundary. Note this definition only applies to the 
 * input binary tree, and not applies to any subtrees.
 * 
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the 
 * left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * 
 * The right-most node is also defined by the same way with left and right exchanged.
 * 
 * Example 1
 * Input:
 *   1
 *    \
 *     2
 *    / \
 *   3   4
 * 
 * Ouput:
 * [1, 3, 4, 2]
 * 
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed 
 * right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 * Example 2
 * nput:
 *     ____1_____
 *    /          \
 *   2            3
 *  / \          / 
 * 4   5        6   
 *    / \      / \
 *   7   8    9  10  
 *        
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 * 
 * Explanation:
 * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 * The leaves are node 4,7,8,9,10.
 * The right boundary are node 1,3,6,10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */
import java.util.*;
public class BoundaryOfBinaryTree {
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return res;
    }
    public void leftBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        res.add(node.val);
        leftBoundary(node.left);
        if (node.left == null) leftBoundary(node.right);
    }
    public void rightBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        rightBoundary(node.right);
        if (node.right == null) rightBoundary(node.left);
        res.add(node.val);
    }
    public void leaves(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
}