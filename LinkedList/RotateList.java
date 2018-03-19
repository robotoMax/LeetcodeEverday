/**
 * 
 * Date: 03/18/2018
 * Created By: Shuai Liu
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * Example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight1(ListNode head, int k) {
        // if k smaller than list's size
        if (head == null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode fast = dum;
        ListNode slow = dum;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        dum.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dum.next;
    }
    // if in general cases, k can be any number
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 0;
        ListNode dum = new ListNode(0);
        ListNode fast = dum;
        ListNode slow = dum;
        dum.next = head;
        while (fast.next != null) {
            fast = fast.next;
            size++;
        }
        for (int i = 0; i < size - k % size; i++) {
            slow = slow.next;
        }
        fast.next = dum.next;
        dum.next = slow.next;
        slow.next = null;
        return dum.next;
    }
}