import java.util.*;
public class WordBreaking {
    public String wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return "";
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dp[j] && wordDict.contains(str)) {
                    dp[i] = true;
                    sb.append(str).append(" ");
                    break;
                }
            }
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        WordBreaking w = new WordBreaking();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.addAll(Arrays.asList("l","e","e","t","code"));
        System.out.println(w.wordBreak(s, wordDict));
    }
}