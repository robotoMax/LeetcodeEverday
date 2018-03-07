/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the 
 * order of characters. No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cache = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i)] != cache[t.charAt(i) + 256]) return false;
            cache[s.charAt(i)] = i + 1;
            cache[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}