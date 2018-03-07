/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int left = 0;
        int right = 0;
        int[] cache = new int[256];
        while (right < s.length()) {
            cache[s.charAt(right++)]++;
            while (left < s.length() && cache[s.charAt(left)] > 0) {
                left++;
            }
        }
        return left == s.length() ? -1 : left;
    }
}