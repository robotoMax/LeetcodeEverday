/**
 * Date: 07/17/2018
 * Created By: Shuai Liu
 * 
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at 
 * most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * Input:
 * s = "ABAB", k = 2
 * Output:
 * 4
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * Example 2:
 * Input:
 * s = "AABABBA", k = 1
 * Output:
 * 4
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] cache = new int[26];
        int res = 0;
        int start = 0;
        int maxCount = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++cache[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                cache[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}