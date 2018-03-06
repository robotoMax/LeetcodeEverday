/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double solution(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return solution(nums2, nums1);
        int low = 0;
        int high = m;
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = (m + n + 1) / 2 - i;
            int A_left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int A_right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int B_left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int B_right = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (A_left > B_right) high = i - 1;
            else if (B_left > A_right) low = i + 1;
            else {
                int max_left = Math.max(A_left, B_left);
                int min_right = Math.min(A_right, B_right);
                if ((m + n) % 2 == 1) return max_left;
                else return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }
}