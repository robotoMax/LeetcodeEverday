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

    int size;
    int[] num;
    double sum = 0;
    int index;
    int n;
    
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        num = new int[size];
    }
    
    public double next(int val) {
        index = n % size;
        sum -= num[index];
        num[index] = val;
        sum += num[index];
        n++;
        return n >= size ? sum / size : sum / n;
    }
}