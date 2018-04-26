/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        // power of four, the 1 bit is always at odd position.
        // 0x55555555 in binary is 0101-0101-0101-0101-0101-0101-0101-0101.
        // it can filter the power of 2, like 8 - 1000.
        return num > 0 && ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }
}