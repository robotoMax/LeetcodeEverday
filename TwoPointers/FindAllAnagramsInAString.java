/**
 * Date: 07/22/2018
 * Created By: Shuai Liu
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int a = 0;
        int b = 0;
        int count = 0;
        int[] cache = new int[256];
        for (char c : p.toCharArray()) cache[c]++;
        for (; b < s.length(); b++) {
            char c = s.charAt(b);
            if (cache[c] > 0) count++;
            cache[c]--;
            if (count == p.length()) res.add(a);
            if (b - a + 1 == p.length()) {
                char d = s.charAt(a);
                if (cache[d] >= 0) count--;
                cache[d]++;
                a++;
            }
        }
        return res;
    }
}