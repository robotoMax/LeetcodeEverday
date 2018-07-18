/**
 * Date: 06/22/1028
 * Created By: Shuai Liu
 * 
 * A character is unique in string S if it occurs exactly once in it.
 * For example, in string S = "LETTER", the only unique characters are "L" and "R".
 * Let's define UNIQ(S) as the number of unique characters in string S.
 * For example, UNIQ("LETTER") =  2.
 * Given a string S with only uppercases, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
 * If there are two or more equal substrings at different positions in S, we consider them different.
 * Since the answer can be very large, retrun the answer modulo 10 ^ 9 + 7.
 * Example 1:
 * Input: "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * 
 * Example 2:
 * Input: "ABA"
 * Output: 8
 * Explanation: The same as example 1, except uni("ABA") = 1.
 * Note: 0 <= S.length <= 10000.
 */
public class UniqueLetterString {
    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2];
        for (int i = 0; i < index.length; i++) Arrays.fill(index[i], -1);
        int res = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'A';
            int p1 = index[c][0];
            int p2 = index[c][1];
            res += ((p2 - p1) * (i - p2) % mod);
            index[c] = new int[] {index[c][1], i};
        }
        for (int i = 0; i < 26; i++) {
            res += ((index[i][1] - index[i][0]) * (S.length() - index[i][1]) % mod);
        }
        return res;
    }
}