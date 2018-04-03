/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * 
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) xor ^= i;
        xor &= -xor; // To find the rightmost bit that is 1. 8 & -8 = 8. 6 & -6 = 2. Same thing use on Binary Indexed Tree  
        int[] res = {0, 0};
        for (int i : nums) {
            if ((i & xor) == 0) res[0] ^= i;
            else res[1] ^= i;
        }
        return res;
    }
}