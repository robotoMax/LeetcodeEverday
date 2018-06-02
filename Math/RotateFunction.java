/**
 * Date: 05/31/2018
 * Created By: Shuai Liu
 * 
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * 
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * Note:
 * n is guaranteed to be less than 105.
 * Example:
 * A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
/**
 * F(0) = 0A + 1B + 2C +3D
 * F(1) = 0D + 1A + 2B +3C
 * F(2) = 0C + 1D + 2A +3B
 * F(3) = 0B + 1C + 2D +3A
 * 那么，我们通过仔细观察，我们可以得出下面的规律：
 * sum = A + B + C + D 
 * F(1) = F(0) + sum - 4D
 * F(2) = F(1) + sum - 4C
 * F(3) = F(2) + sum - 4B
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            f += i * A[i];
        }
        int res = f;
        for (int i = A.length - 1; i > 0; i--) {
            f = f - A.length * A[i] + sum;
            res = Math.max(res, f);
        }
        return res;
    }
}