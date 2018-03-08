/**
 * 
 * Date: 03/07/2018
 * Created By: Shuai Liu
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * 
 * Examples: 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * 
 * Note: 
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */
import java.util.*;
public class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new double[0];
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian();
                remove(nums[i - k + 1]);
            }
        }
        return res;
    }
    public void add(int num) {
        if (num < getMedian()) {
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
    public void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else minHeap.remove(num);
        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    public double getMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0;
        if (minHeap.size() == maxHeap.size()) return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        else return (double) minHeap.peek();
    }
}