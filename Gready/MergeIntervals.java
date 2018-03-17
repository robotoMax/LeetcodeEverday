/**
 * 
 * Date: 03/14/2018
 * Created By: Shuai Liu
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
import java.util.*;
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, (a, b) -> {
            if (a.start == b.start) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals) {
            if (i.start > end) {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
            else {
                end = Math.max(end, i.end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}