/**
 * 
 * Date: 03/29/2018
 * Created By: Shuai Liu
 * 
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length 
 * k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return 
 * an array of the k digits. You should try to optimize your time and space complexity.
 * 
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        for (int i = Math.max(0, k - n); i <=m && i <= k; i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            res = greater(temp, 0, res, 0) ? temp : res;
        }
        return res;
    }
    public int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j > 0 && nums.length - i > k - j && nums[i] > res[j - 1]) j--;
            if (j < k) {
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }
    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; k < res.length; k++) {
            res[k] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        } 
        return (j == nums2.length) || (i < nums1.length && nums1[i] > nums2[j]);
    }
}