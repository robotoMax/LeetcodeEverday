/**
 * 
 * Date: 03/09/2018
 * Created By: Shuai Liu
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * x is guaranteed to be a non-negative integer.
 * Example 1:
 * 
 * Input: 4
 * Output: 2
 * Example 2:
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (true) {
            int mid = (high - low) / 2 + low;
            if (mid > x / mid) {
                high = mid - 1;
            }
            else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                else low = mid + 1;
            }
        }
    }
}