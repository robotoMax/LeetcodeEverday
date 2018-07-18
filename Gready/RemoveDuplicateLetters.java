/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * 
 * Example:
 * Given "bcabc"
 * Return "abc"
 * 
 * Given "cbacdcbc"
 * Return "acdb"
 */
/**
 * Given the string s, the greedy choice (i.e., the leftmost letter in the answer) is the smallest s[i], s.t.
 * the suffix s[i … ] contains all the unique letters. (Note that, when there are more than one smallest s[i]'s, 
 * we choose the leftmost one. Why? Simply consider the example: “abcacb”.)
 * After determining the greedy choice s[i], we get a new string s’ from s by
 * removing all letters to the left of s[i],
 * removing all s[i]'s from s.
 * We then recursively solve the problem w.r.t. s’.
 * The runtime is O(26 * n) = O(n).
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return "";
        int[] cache = new int[26];
        for (char c : s.toCharArray()) cache[c - 'a']++;
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            cache[s.charAt(i) - 'a']--;
            if (cache[s.charAt(i) - 'a'] == 0) break;
        }
        return s.charAt(pos) + "" + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
    }
}