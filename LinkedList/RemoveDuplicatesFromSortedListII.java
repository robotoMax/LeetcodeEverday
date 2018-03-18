/**
 * 
 * Date: 03/17/2018
 * Created By: Shuai Liu
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from 
 * the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        ListNode pre = dum;
        dum.next = head;
        while (head != null && head.next != null) {
            while (head.next != null && head.val == head.next.val) head = head.next;
            if (pre.next != head) pre.next = head.next;
            else pre = pre.next;
            head = head.next;
        }
        return dum.next;
    }
}