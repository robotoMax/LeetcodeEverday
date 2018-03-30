/**
 * 
 * Date: 03/27/2018
 * Created By: Shuai Liu
 * 
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] cache = new int[256];
        int res = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            char S = s.charAt(j);
            if (cache[S] == 0) count++;
            cache[S]++;
            while (count > k) {
                if (cache[s.charAt(i)] <= 1) count--;
                cache[s.charAt(i)]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Test t = new Test();
        String s = "eceba";
        int k = 2;
        System.out.println(t.lengthOfLongestSubstringKDistinct(s, k));
    }
}