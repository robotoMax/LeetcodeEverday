/**
 * 
 * Date: 03/29/2018
 * Created By: Shuai Liu
 * 
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. 
 * If it is a null node, we record using a sentinel value such as #.
 * 
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. 
 * Find an algorithm without reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * Example 2:
 * "1,#"
 * Return false
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
/**
 * when you iterate through the preorder traversal string, for each char:
 * 
 * case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack
 * case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for 
 * next coming node k to know it is being the right child.
 * case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the sub tree 
 * (rooted as t, for example) with these two-# children. But wait, after the cancellation, you continue to check top of stack 
 * is whether # or a number:
 * ---- if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the 
 * top of stack. So that the next node know it is a right child.
 * ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel sub tree 
 * of u, and the process goes on and on.
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            while (!stack.isEmpty() && str.equals("#") && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}