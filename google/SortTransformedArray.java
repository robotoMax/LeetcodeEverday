/**
 * 
 * Date: 04/16/2018
 * Created By: Shuai Liu
 * 
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form 
 * f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[nums.length];
        int pointer = a < 0 ? i : j;
        while (i <= j) {
            if (a < 0) {
                int left = product(a, b, c, nums[i]);
                int right = product(a, b, c, nums[j]);
                res[pointer++] = left < right ? product(a, b, c, nums[i++]) : product(a, b, c, nums[j--]);
            }
            else {
                int left = product(a, b, c, nums[i]);
                int right = product(a, b, c, nums[j]);
                res[pointer--] = left > right ? product(a, b, c, nums[i++]) : product(a, b, c, nums[j--]);
            }
        }
        return res;
    }
    public int product(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}