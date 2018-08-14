/**
 * Date: 06/07/2018
 * Created By: Shuai Liu
 * 
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
// Similar with 715. Range Module
import java.util.*;
public class DataStreamAsDisjointIntervals {

    TreeMap<Integer, Interval> map;

    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        if (l != null && h != null && map.get(l).end + 1 == val && h == val + 1) {
            map.get(l).end = map.get(h).end;
            map.remove(h);
        }
        else if (l != null && map.get(l).end + 1 >= val) {
            map.get(l).end = Math.max(val, map.get(l).end);
        }
        else if (h != null && h == val + 1) {
            map.put(val, new Interval(val, map.get(h).end));
            map.remove(h);
        }
        else map.put(val, new Interval(val, val));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}