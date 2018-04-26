/**
 * 
 * Date: 04/08/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run 
 * in linear time and in O(1) space.
 */
import java.util.*;
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i : nums) {
            if (num1 == i) count1++;
            else if (num2 == i) count2++;
            else if (count1 == 0) {
                num1 = i;
                count1++;
            }
            else if (count2 == 0) {
                num2 = i;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == num1) count1++;
            else if (i == num2) count2++;
        }
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;
    }
}