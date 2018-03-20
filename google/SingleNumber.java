/**
 * 
 * Date: 03/19/2018
 * Created By: Shuai Liu
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}