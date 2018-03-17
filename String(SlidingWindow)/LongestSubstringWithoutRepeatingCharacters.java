/**
 * 
 * Date: 03/14/2018
 * Created By: Shuai Liu
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
 * "pwke" is a subsequence and not a substring.
 */
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            if (set.add(s.charAt(right))) right++;
            else {
                while (left < s.length() && set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}