/**
 * 
 * Date: 03/28/2018
 * Created By: Shuai Liu
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {

        int[] window;
        int num;
        int index;
        long sum;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        window = new int[size];
        num = 0;
        index = 0;
        sum = 0;
    }

    public double next(int val) {
        if (num < window.length) num++;
        sum -= window[index];
        sum += val;
        window[index] = val;
        index = (index + 1) % window.length;
        return (double) sum / num;
    }
}