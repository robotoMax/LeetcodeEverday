/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 
 * 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int u2 = nums[1], u3 = nums[1], u5 = nums[1];
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = Math.min(u2, Math.min(u3, u5));
            if (nums[i] == u2) u2 = nums[++i2] * 2;
            if (nums[i] == u3) u3 = nums[++i3] * 3;
            if (nums[i] == u5) u5 = nums[++i5] * 5;
        }
        return nums[n];
    }
}