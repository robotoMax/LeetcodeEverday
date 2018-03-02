import java.util.*;
import java.lang.*;
public class JosephusProblem {

    // For killing every other people sitting in a circle clockwise,
    // The easiest way to get answer is first turning the number of people into binary, 
    // then make the left most 1 bit to the right most.
    // 41 -> 10101 -> 01011 -> 19
    // k means people who are called k, killed.
    // 1,2,3,4,5..... if k = 2, then 2, 4 will die
    public int JosephusUsingQueue(int n, int k) {
        if (n <= 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int count = 0;
        while (queue.size() > 1) {
            count++;
            if (count == k) {
                queue.poll();
                count = 0;
            }
            else queue.add(queue.poll());
        }
        return queue.peek();
    }

    public int JosephusUsingList(int n, int k) {
        List<Integer> list = new ArrayList<>();  
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1) {  
            count += k;
            count = count % (list.size()) - 1;
            if (count < 0) {
                list.remove(list.size() - 1);
                count = 0;
            }
            else {
                list.remove(count);
            }
        }
        return list.get(0);
    }

    // anticlockwise
    public int JosephusAnticlockwise(int n, int k) {
        if (n <= 0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = n; i > 1; i--) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1) {
            count += k;
            count = count % (list.size()) - 1;
            if (count < 0) {
                list.remove(list.size() - 1);
                count = 0;
            }
            else {
                list.remove(count);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        JosephusProblem j = new JosephusProblem();
        System.out.println(j.JosephusAnticlockwise(13, 2));
    }

}