/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * Example 1
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
/**
 * This problem is similar with first missing positive.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        // method that sovles first missing positive.
        for (int i = 0; i < nums.length; i++) {
            // nums[i] needs to be small than the nums.length, if not then nums[nums[i]] will out of bound
            while (nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
    // XOR
    public int missingNumber1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }
        res ^= nums.length;
        return res;
    }
    // get the expected sum, then get the real sum. The difference is the result.
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        int expectedSum = (0 + nums.length) * (nums.length + 1) / 2;
        return expectedSum - sum;
    }
}