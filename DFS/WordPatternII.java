/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * 
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */
import java.util.*;
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Set<String> visited = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        return helper(pattern, 0, str, 0, visited, map);
    }
    public boolean helper(String pattern, int i, String str, int j, Set<String> visited, Map<Character, String> map) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() && j != str.length()) return false;
        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String temp = map.get(c);
            if (!str.startsWith(temp, j)) return false;
            return helper(pattern, i + 1, str, j + temp.length(), visited, map);
        }
        for (int k = j; k < str.length(); k++) {
            String sub = str.substring(j, k + 1);
            if (!visited.add(sub)) continue;
            map.put(c, sub);
            if (helper(pattern, i + 1, str, k + 1, visited, map)) return true;
            visited.remove(sub);
            map.remove(c);
        }
        return false;
    }
}