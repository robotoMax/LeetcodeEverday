/**
 * 
 * Date: 03/19/2018
 * Created By: Shuai Liu
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
import java.util.*;
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).end) i++;
        while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            int start = Math.min(intervals.get(i).start, newInterval.start);
            int end = Math.max(intervals.get(i).end, newInterval.end);
            newInterval = new Interval(start, end);
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}