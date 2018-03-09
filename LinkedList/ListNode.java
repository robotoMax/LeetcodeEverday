import java.util.Random;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public static ListNode createdListNode(int num) {
        Random rand = new Random();
        ListNode res = new ListNode(rand.nextInt(10));
        while (num >= 0) {
            res.next = new ListNode(rand.nextInt(10));
            res = res.next;
            num--;
        }
        return res;
    }
}