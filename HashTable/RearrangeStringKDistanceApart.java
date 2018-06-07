/**
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least 
 * distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an 
 * empty string "".
 * 
 * Example 1:
 * s = "aabbcc", k = 3
 * Result: "abcabc"
 * The same letters are at least distance 3 from each other.
 * 
 * Example 2:
 * s = "aaabc", k = 3 
 * Answer: ""
 * It is not possible to rearrange the string.
 * 
 * Example 3:
 * s = "aaadbbcc", k = 2
 * Answer: "abacabcd" 
 * Another possible answer is: "abcabcda"
 * The same letters are at least distance 2 from each other.
 */
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        int[] counts = new int[26];
        int[] valid = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) counts[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            int candidate = getCandidate(counts, valid, i);
            if (candidate == -1) return "";
            sb.append((char) (candidate + 'a'));
            counts[candidate]--;
            valid[candidate] = i + k;
        }
        return sb.toString();
    }
    public int getCandidate(int[] counts, int[] valid, int index) {
        int res = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            if (counts[i] > max && valid[i] <= index) {
                max = counts[i];
                res = i;
            }
        }
        return res;
    }
}