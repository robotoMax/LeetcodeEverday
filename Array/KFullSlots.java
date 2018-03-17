import java.util.*;
public class KFullSlots {
    public static int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0) return 0;
        if (k == flowers.length) return k;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(flowers.length + 1);
        for (int i = flowers.length - 1; i >= 0; i--) {
            int cur = flowers[i];
            Integer pre = set.lower(cur);
            if (pre != null && cur - pre - 1 == k) {
                return i;
            }
            Integer next = set.higher(cur);
            if (next != null && next - cur - 1 == k) {
                return i;
            }
            set.add(flowers[i]);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] flowers = {1};
        int k = 1;
        System.out.println(kEmptySlots(flowers, k));
    }
}