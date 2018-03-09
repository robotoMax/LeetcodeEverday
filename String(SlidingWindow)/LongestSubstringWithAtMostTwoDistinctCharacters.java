/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] cache = new int[256];
        int res = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i)] == 0) count++;
            cache[s.charAt(i)]++;
            while (count > 2) {
                if (cache[s.charAt(j)] == 1) count--;
                cache[s.charAt(j)]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}