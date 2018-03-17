/**
 * 
 * Date: 03/14/2018
 * Created By: Shuai Liu
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        int[] cache = new int[256];
        for (char c : s.toCharArray()) cache[c]++;
        int odd = 0;
        for (int i : cache) {
            if (i % 2 == 1) odd++;
        }
        return odd <= 1;
    }
}