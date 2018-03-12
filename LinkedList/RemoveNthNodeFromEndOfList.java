/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode fast = dum;
        ListNode slow = dum;
        while (fast != null) {
            if (n < 0) slow = slow.next;
            else n--;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dum.next;
    }
}