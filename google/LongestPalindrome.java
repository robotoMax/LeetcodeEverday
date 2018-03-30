/**
 * 
 * Date: 03/27/2018
 * Created By: Shuai Liu
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be 
 * built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
import java.util.*;
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                res += 2;
                set.remove(c);
            }
            else set.add(c);
        }
        return set.size() >= 1 ? res + 1 : res;
    }
}