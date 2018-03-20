import java.util.*;
public class KthSmallestElementInAnArray {
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // System.out.println("low: " + low);
            // System.out.println("high: " + high);
            int pos = partition(nums, low, high);
            // System.out.println("pos: " + pos);
            if (pos == k - 1) return nums[pos];
            if (pos > k - 1) high = pos - 1;
            else low = pos + 1;
        }
        return 0;
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int l = low + 1;
        int r = high;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l, r);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, low, r);
        return r;
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }


    public static void main(String[] args) {
        KthSmallestElementInAnArray kth = new KthSmallestElementInAnArray();
        int[] nums = {6,2,5,6,1,4,6,7,34,97,5,14,45};
        int[] nums1 = {1};
        int k1 = 1;
        int k = 4;
        System.out.println(kth.findKthSmallest(nums, k));
        kth.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}