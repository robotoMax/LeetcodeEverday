/**
 * Date: 05/31/2018
 * Created By: Shuai Liu
 * 
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in 
 * T appears no less than k times.
 * 
 * Example 1:
 * Input:
 * s = "aaabb", k = 3
 * Output:
 * 3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * Example 2:
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || len < k) return 0;
        if (k == 1) return len;
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 'a']++;
        char badchar = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                badchar = (char) (i + 'a');
                break;
            }
        }
        if (badchar == 0) return len;
        int res = 0;
        String[] strs = s.split(badchar + "");
        for (String str : strs) {
            res = Math.max(res, longestSubstring(str, k));
        }
        return res;
    }
}