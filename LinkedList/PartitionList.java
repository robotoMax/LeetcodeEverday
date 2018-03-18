/**
 * 
 * Date: 03/17/2018
 * Created By: Shuai Liu
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater 
 * than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode bigDum = big;
        ListNode smallDum = small;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }
            else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigDum.next;
        big.next = null;
        return smallDum.next;
    }
}