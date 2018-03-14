/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
 * You may assume the dictionary does not contain duplicate words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */
import java.util.*;
public class WordBreak {
    public boolean solution(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dp[j] && wordDict.contains(str)) {
                    dp[i] = true;
                    break;
                }
                else dp[i] = false;
            }
        }
        return dp[s.length()];
    }
    public static String solution1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return "";
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dp[j] && wordDict.contains(str)) {
                    dp[i] = true;
                    sb.append(str).append(" ");
                    break;
                }
                else dp[i] = false;
            }
        }
        return sb.toString().trim(); // this will return "leet code"
    }
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        String[] dict = {"leet", "code"};
        wordDict.addAll(Arrays.asList(dict));
        String s = "leetcode";
        System.out.println(solution1(s, wordDict));
    }
}