/**
 * 
 * Date: 03/20/2018
 * Created By: Shuai Liu
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
import java.util.*;
public class MajorityElement {
    // HashMap
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > nums.length / 2) {
                res = i;
                break;
            }
        }
        return res;
    }
    // Moore voting algorithm
    public int majorityElement1(int[] nums) {
        int count = 0;
        int res = 0;
        for (int n : nums) {
            if (count == 0) res = n;
            if (res == n) count++;
            else count--;
        }
        return res;
    }
}
/**
 * follow up: if the input is very large for PB? what should we do?
 * Answer: MapReduce.
 */