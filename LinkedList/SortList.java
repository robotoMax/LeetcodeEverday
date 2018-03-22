/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
/**
 * merge sort
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMiddle(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(next));
    }
    public ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            }
            else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) cur.next = a;
        if (b != null) cur.next = b;
        return dum.next;
    }
}   