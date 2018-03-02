import java.util.*;
public class MeetingRoom {
    public int solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for (Interval a : intervals) {
            list.add(new int[] {a.start, 1});
            list.add(new int[] {a.end, 0});
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] == 1) cnt++;
            if (list.get(i)[1] == 0) cnt--;
            res = Math.max(res, cnt);
        }
        return res;
    }

    public int solution1(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a.start == b.start) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        heap.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval temp = heap.poll();
            if (temp.end <= intervals[i].start) {
                temp.end = intervals[i].end;
            }
            else {
                heap.add(intervals[i]);
            }
            heap.add(temp);
        }
        return heap.size();
    }


}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}