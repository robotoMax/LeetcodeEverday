/**
 * 
 * Date: 04/08/2018
 * Created By: Shuai Liu
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode temp = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }
}