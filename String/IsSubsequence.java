import java.util.Collections;

/**
 * Date: 05/31/2018
 * Created By: Shuai Liu
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, 
 * and s is a short string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
 * without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. \
 * In this scenario, how would you change your code?
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] lists = new List[256];
        for (int i = 0; i < t.length(); i++) {
            if (lists[t.charAt(i)] == null) lists[t.charAt(i)] = new ArrayList<>();
            lists[t.charAt(i)].add(i);
        }
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lists[s.charAt(i)] == null) return false;
            int j = Collections.binarySearch(lists[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == lists[s.charAt(i)].size()) return false;
            prev = lists[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}