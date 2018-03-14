/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given an array of integers and an integer k, find out whether there are 
 * two distinct indices i and j in the array such that nums[i] = nums[j] and the 
 * absolute difference between i and j is at most k.
 */
import java.util.*;
 public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}