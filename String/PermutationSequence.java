/**
 * 
 * Date: 03/19/2018
 * Created By: Shuai Liu
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.*;
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n == 0) return "";
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorial[i] = factorial[i - 1] * i;
        }
        k--; 
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }
}