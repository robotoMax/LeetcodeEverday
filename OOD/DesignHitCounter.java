import java.util.*;
public class DesignHitCounter {

    // method 1
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) queue.poll();
        return queue.size();
    }
    // **************************************************************************************
    // method 2
    int[] times;
    int[] hits;
    public void initialize() {
        this.times = new int[300];
        this.hits = new int[300];
    }
    public void hit1(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        }
        else hits[index]++;
    }
    public int getHits1(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) res += hits[i];
        }
        return res;
    }

}