/**
 * Date: 08/22/2018
 * Created By: Shuai Liu
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast.next = head;
        slow.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow;
        ListNode mid = slow.next;
        while (mid.next != null) {
            ListNode cur = mid.next;
            mid.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        fast = slow.next;
        slow = head;
        while (slow != pre) {
            pre.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = pre.next;
        }
    }
}