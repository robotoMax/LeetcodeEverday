/**
 * 03/05/2018
 * Created by: Stuart
 * 
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * can you solve it without using extra space.
 */

public class LinkedListCycle {
    public boolean solution(ListNode head) {
        if (head == null) return false;
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast.next = head;
        slow.next = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}