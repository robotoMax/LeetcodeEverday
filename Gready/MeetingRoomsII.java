/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
/**
 * 0 ____________________________ 30
 *    5 ______ 10
 *          8 _______________20
 * return 3;
 */
import java.util.*;
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(new int[] {i.start, 1});
            list.add(new int[] {i.end, 0});
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int res = 0;
        int count = 0;
        for (int[] time : list) {
            if (time[1] == 1) count++;
            if (time[1] == 0) count--;
            res = Math.max(res, count);
        }
        return res;
    }
}