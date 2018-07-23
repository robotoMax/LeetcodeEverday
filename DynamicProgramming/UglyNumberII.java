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
        int[] ugly = new int[n];
        int next2 = 1;
        int next3 = 1;
        int next5 = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 0; i < n; i++) {
            ugly[i] = Math.min(next2, Math.min(next3, next5));
            if (ugly[i] == next2) next2 = ugly[index2++] * 2;
            if (ugly[i] == next3) next3 = ugly[index3++] * 3;
            if (ugly[i] == next5) next5 = ugly[index5++] * 5;
        }
        return ugly[n - 1];
    }
}