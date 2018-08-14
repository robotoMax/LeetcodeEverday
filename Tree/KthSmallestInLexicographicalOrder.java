/**
 * Date: 07/22/2018
 * Created By: Shuai Liu
 * 
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 * Note: 1 ≤ k ≤ n ≤ 109.
 * Example:
 * Input:
 * n: 13   k: 2
 * 
 * Output:
 * 10
 * 
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = calStep(n, cur, cur + 1); // how many steps we need to go from cur to cur + 1 in range of n
            if (steps <= k) {
                cur++;
                k -= steps;
            }
            else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
    public int calStep(int n, long n1, long n2) {
        int res = 0;
        while (n >= n1) {
            res += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return res;
    }
}