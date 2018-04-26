import java.util.*;
public class SegmentTree {
    
    int[] nums;
    int[] segmentTree;
    
    public void buildTree(int[] input) {
        nums = input;
        int len = input.length;
        int n = (int) (Math.log(len) / Math.log(2)) + 1;
        int size = 2 * (int) Math.pow(2, n) - 1;
        segmentTree = new int[size];
        constructTree(0, len - 1, 0);
    }

    public void constructTree(int start, int end, int pos) {
        if (start == end) {
            segmentTree[pos] = input[start];
            return;
        }
        int mid = (high - low) / 2 + low;
        constructTree(start, mid, 2 * pos + 1);
        constructTree(mid + 1, high, 2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateValue(0, nums.length - 1, index, diff, 0);
    }

    public void updateValue(int low, int high, int index, int delta, int pos) {
        if (index < low || index > high) return;
        if (low == high) {
            segmentTree[pos] += delta;
            return;
        }
        int mid = (high - low) / 2 + low;
        updateValue(low, mid, index, delta, 2 * pos + 1);
        updateValue(mid + 1, high, index, delta, 2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }
    
    public int rangeQuery(int i, int j) {
        return minQuery(i, j, 0, nums.length - 1, 0);
    }

    public int minQuery(int qLow, int qHigh, int low, int high, int pos) {
        if (qLow <= low && qHigh >= high) {
            return segmentTree[pos];
        }
        if (qLow > high || qHigh < low) return Integer.MAX_VALUE;
        int mid = (high - low) / 2 + low;
        return Math.min(minQuery(qLow, qHigh, low, mid, 2 * pos + 1), minQuery(qLow, qHigh, mid + 1, high, 2 * pos + 2));
    }
}