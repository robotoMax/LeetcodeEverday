/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * Input: 
 * 
          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

 */
import java.util.*;
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right =new ArrayList<>();
        return helper(root, left, right, 1, 0);
    }
    public int helper(TreeNode root, List<Integer> left, List<Integer> right, int index, int level) {
        if (root == null) return 0;
        if (left.size() == level) {
            left.add(index);
            right.add(index);
        }
        else right.set(level, index);
        int cur = right.get(level) - left.get(level) + 1;
        int lVal = helper(root.left, left, right, 2 * index, level + 1);
        int rVal = helper(root.right, left, right, 2 * index + 1, level + 1);
        return Math.max(Math.max(lVal, rVal), cur);
    }
}