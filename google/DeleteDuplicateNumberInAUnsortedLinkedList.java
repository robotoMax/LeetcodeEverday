/**
 * 给你一个list，让你去掉其中重复的数，而且不需要in place
 */
// in place method
public class DeleteDuplicateNumberInAUnsortedLinkedList {
    public ListNode deleteDuplicate(ListNode head) {
        head = sort(head);
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (pre.next != head) pre.next = head.next;
            else pre = pre.next;
            head = head.next;
        }
        return dum.next;
    }

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMiddle(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sort(head), sort(next));
    }

    public ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
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
class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {this.val = val;}
}