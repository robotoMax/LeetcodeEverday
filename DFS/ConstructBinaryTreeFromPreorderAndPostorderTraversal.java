/**
 * Date: 08/21/2018
 * Created By: Shuai Liu
 * 
 * Return any binary tree that matches the given preorder and postorder traversals.
 * Values in the traversals pre and post are distinct positive integers.
 * Example 1:
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * Note:
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
import java.util.*;
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; i++) {
            TreeNode node  = new TreeNode(pre[i]);
            while (deque.isEmpty() && post[j] == deque.getLast().val) {
                j++;
                deque.pollLast();
            }
            if (deque.getLast().left == null) deque.getLast().left = node;
            else deque.getLast().right = node;
        }
        return deque.poll();
    }
}