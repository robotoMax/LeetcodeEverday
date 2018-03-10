/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest 
 * element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

import java.util.*;
public class KthLargestElementInAnArray {
    // quick select
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int pos = helper(nums, low, high);
            if (pos == k - 1) return nums[pos];
            if (pos > k - 1) high = pos - 1;
            else low = pos + 1;
        }
        return 0;
    }
    public int helper(int[] nums, int i, int j) {
        int pivot = nums[i];
        int x = i + 1;
        int y = j;
        while (x <= y) {
            if (nums[x] < pivot && nums[y] > pivot) {
                swap(nums, x, y);
            }
            if (nums[x] >= pivot) x++;
            if (nums[y] <= pivot) y--;
        }
        swap(nums, i, y);
        return y;
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    // priorityqueue
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }    
}