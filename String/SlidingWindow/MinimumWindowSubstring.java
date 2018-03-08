/**
 * Given a string S and a string T, find the minimum window in S which will contain all 
 * the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always 
 * be only one unique minimum window in S.
 */
/**
 * Using sliding window to solve this problem
 */
import java.util.*;
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] cache = new int[256];
        for (char c : t.toCharArray()) {
            cache[c]++;
        }
        int count = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i)] > 0) count++;
            cache[s.charAt(i)]--;
            while (count == t.length()) {
                if (len > (i - j + 1)) {
                    res = s.substring(j, i + 1);
                    len = res.length();
                }
                if (cache[s.charAt(j)] == 0) count--;
                cache[s.charAt(j)]++;
                j++;
            }
        }
        return res;
    }
}