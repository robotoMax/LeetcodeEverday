/**
 * 
 * Date: 03/09/2018
 * Created By: Shuai Liu
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
import java.util.*;
public class AddTwoNumbersII {
    // using stack
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode dum = new ListNode(0);
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop().val;
            if (!s2.isEmpty()) sum += s2.pop().val;
            dum.val = sum % 10;
            ListNode next = new ListNode(sum / 10);
            next.next = dum;
            dum = next;
            sum /= 10;
        }
        if (sum == 0) return dum.next;
        return dum;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}