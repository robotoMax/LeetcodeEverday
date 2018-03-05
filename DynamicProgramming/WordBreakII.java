/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */
import java.util.*;
public class WordBreakII {
    public List<String> solution(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<Integer, List<String>> map = new HashMap<>();
        return helper(s, wordDict, map, 0);
    }
    public List<String> helper(String s, List<String> dict, Map<Integer, List<String>> map, int pos) {
        if (map.containsKey(pos)) {
            return map.get(pos);
        }
        List<String> res = new ArrayList<>();
        if (pos == s.length()) {
            res.add("");
            return res;
        }
        for (int i = pos; i < s.length(); i++) {
            String str = s.substring(pos, i + 1);
            if (dict.contains(str)) {
                List<String> list = helper(s, dict, map, i + 1);
                for (String temp : list) {
                    res.add(str + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(pos, res);
        return res;
    }
}