/**
 * 
 * Date: 03/28/2018
 * Created By: Shuai Liu
 * 
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * 1. What if the given array is already sorted? How would you optimize your algorithm?
 * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into 
 * the memory at once?
 */
import java.util.*;
public class IntersectionOfTwoArraysII {
    // hashmap solution
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer temp = map.get(nums2[i]);
            if (temp != null) {
                list.add(nums2[i]);
                temp--;
                if (temp == 0) map.remove(nums2[i]);
                else map.put(nums2[i], temp);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
    // two pointers + sorted array
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else i++;
        }
        int[] res = new int[list.size()];
        for (int p = 0; p < res.length; p++) res[p] = list.get(p);
        return res;
    }
}