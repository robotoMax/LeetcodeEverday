/**
 * Date: 06/11/2018
 * Created By: Shuai Liu
 * 
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their 
 * binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * 1. It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly 
 * in a single pass?
 * 2. Space complexity should be O(n).
 * 3. Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 1;
        if (num == 0) return res;
        res[1] = 1;
        for (int i = 2; i <= num; i++) res[i] = res[i >> 1] + (i & 1);
        return res;
    }
}
/**
 * Explaination.
 * Take number X for example, 10011001.
 * Divide it in 2 parts:
 * <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
 * <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
 */