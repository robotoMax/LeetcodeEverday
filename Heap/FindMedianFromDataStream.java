/**
 * 
 * Date: 03/07/2018
 * Created By: Shuai Liu
 * 
 * Median is the middle value in an ordered integer list. 
 * If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * 
 * Examples: 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 */
// this question is same as 239. Sliding Window Maximum
import java.util.*;
public class FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        if (num < findMedian()) {
            maxHeap.add(num);
        }
        else minHeap.add(num);
        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) return 0;
        if (maxHeap.size() == minHeap.size()) return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        return (double) minHeap.peek();
    }
}