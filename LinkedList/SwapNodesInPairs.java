/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    // iterative
    public ListNode swapPairsIter(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode fast = head;
        ListNode slow = dum;
        while (fast != null && fast.next != null) {
            ListNode temp = fast.next.next;
            slow.next = fast.next;
            slow.next.next = fast;
            fast.next = temp;
            slow = fast;
            fast = temp;
        }
        return dum.next;
    }
    // recursion
    public ListNode swapPairsRecur(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairsRecur(head.next.next);
        next.next = head;
        return next;
    }
}