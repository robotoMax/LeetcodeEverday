/**
 * Date: 07/19/2018
 * Created By: Shuai Liu
 * Write a program to find the nth super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * 
 * Example:
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32 
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 * 
 * Note:
 * 1. 1 is a super ugly number for any given primes.
 * 2. The given numbers in primes are in ascending order.
 * 3. 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * 4. The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] next = new int[primes.length];
        int[] index = new int[primes.length];
        int val = 1;
        Arrays.fill(next, 1);
        for (int i = 0; i < n; i++) {
            ugly[i] = val;
            val = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[i] == next[j]) next[j] = ugly[index[j]++] * primes[j];
                val = Math.min(val, next[j]);
            }
        }
        return ugly[n - 1];
    }
}