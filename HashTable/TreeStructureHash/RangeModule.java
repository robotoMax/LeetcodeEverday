/**
 * 
 * Date: 04/12/2018
 * Created By: Shuai Liu
 * 
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in 
 * an efficient manner.
 * 
 * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. 
 * Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) 
 * that are not already tracked.
 * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
 * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
 * 
 * Example 1:
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 * 
 * Note:
 * 1. A half open interval [left, right) denotes all real numbers left <= x < right.
 * 2. 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
 * 3. The total number of calls to addRange in a single test case is at most 1000.
 * 4. The total number of calls to queryRange in a single test case is at most 5000.
 * 5. The total number of calls to removeRange in a single test case is at most 1000.
 */
import java.util.*;
class RangeModule {

    private class Interval {
        int left;
        int right;
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    TreeSet<Interval> set;

    public RangeModule() {
        set = new TreeSet<>((a, b) -> {
            if (a.right == b.right) return Integer.compare(a.left, b.left);
            return Integer.compare(a.right, b.right);
        });
    }
    
    public void addRange(int left, int right) {
        Iterator<Interval> itr = set.tailSet(new Interval(0, left)).iterator();
        while (itr.hasNext()) {
            Interval cur = itr.next();
            if (cur.left > right) break;
            left = Math.min(left, cur.left);
            right = Math.max(right, cur.right);
            itr.remove();
        }
        set.add(new Interval(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Interval big = set.higher(new Interval(left - 1, right - 1));
        return big != null && big.left <= left && big.right >= right;
    }
    
    public void removeRange(int left, int right) {
        Iterator<Interval> it = set.tailSet(new Interval(0, left)).iterator();
        List<Interval> list = new ArrayList<>();
        while (it.hasNext()) {
            Interval cur = it.next();
            if (cur.left > right) break;
            if (left > cur.left) list.add(new Interval(cur.left, left));
            if (cur.right > right) list.add(new Interval(right, cur.right));
            it.remove();
        }
        for (Interval i : list) set.add(i);
    }
}