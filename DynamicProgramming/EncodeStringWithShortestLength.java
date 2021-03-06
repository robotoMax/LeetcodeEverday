/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty string, encode the string such that its encoded length is the shortest.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets 
 * is being repeated exactly k times.
 * 
 * Note:
 * k will be a positive integer and encoded string will not be empty or have extra space.
 * You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
 * If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return 
 * any of them is fine.
 * Example 1:
 * 
 * Input: "aaa"
 * Output: "aaa"
 * Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
 * Example 2:
 * 
 * Input: "aaaaa"
 * Output: "5[a]"
 * Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
 * Example 3:
 * 
 * Input: "aaaaaaaaaa"
 * Output: "10[a]"
 * Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".
 * Example 4:
 * 
 * Input: "aabcaabcd"
 * Output: "2[aabc]d"
 * Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
 * Example 5:
 * 
 * Input: "abbbabbbcabbbabbbc"
 * Output: "2[2[abbb]c]"
 * Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".
 * 
 */
/**
 * using kmp doing the pattern searching
 */
public class EncodeStringWithShortestLength {
    public String encode(String s) {
        if (s == null || s.length() == 0) return "";
        String[][] dp = new String[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                dp[i][j] = s.substring(i, j + 1);
                if (l < 4) continue;
                for (int k = i; k < j; k++) {
                    if (dp[i][j].length() > (dp[i][k] + dp[k + 1][j]).length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
                String pat = KMP(s.substring(i, j + 1));
                if (pat.length() == s.substring(i, j + 1).length()) continue;
                String encode = s.substring(i, j + 1).length() / pat.length() + "[" + dp[i][i + pat.length() - 1] + "]";
                if (encode.length() < dp[i][j].length()) dp[i][j] = encode;
            }
        }
        return dp[0][s.length() - 1];
    }
    public String KMP(String str) {
        int index = 0;
        int[] temp = new int[str.length()];
        int i = 1;
        temp[0] = 0;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(index)) {
                temp[i] = index + 1;
                i++;
                index++;
            }
            else {
                if (index != 0) {
                    index = temp[index - 1];
                }
                else i++;
            }
        }
        int len = str.length() - temp[str.length() - 1];
        if (len != str.length() && str.length() % len == 0) return str.substring(0, len);
        return str;
    }
}