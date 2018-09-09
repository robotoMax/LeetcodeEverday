/**
 * Date: 08/24/2018
 * Created By: Shuai Liu
 * 
 * Sort a linked list using insertion sort.
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre, temp = null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) cur = cur.next;
            else {
                pre = dum;
                temp = cur.next;
                cur.next = temp.next;
                while (temp.val >= pre.next.val) pre = pre.next;
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dum.next;
    }
}