/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given an array of integers, find if the array contains any duplicates. Your function should 
 * return true if any value appears at least twice in the array, and it should return false if every element 
 * is distinct.
 */
import java.util.*;
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }
}