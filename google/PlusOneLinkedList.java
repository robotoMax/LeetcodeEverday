/**
 * 
 * Date: 04/15/2018
 * Created By: Shuai Liu
 * 
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Example:
 * Input:
 * 1->2->3
 * Output:
 * 1->2->4
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode dum = new ListNode(0);
        ListNode lastNotNine = dum;
        dum.next = head;
        ListNode node = head;
        while (node != null) {
            if (node.val != 9) lastNotNine = node;
            node = node.next;
        } 
        lastNotNine.val++;
        node = lastNotNine.next;
        while (node != null) {
            node.val = 0;
            node = node.next;
        }
        return dum.val == 1 ? dum : dum.next;
    }
}