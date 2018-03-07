/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 * 
 * Example 1:
 * Given the following words in dictionary,
 * 
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 * The correct order is: "wertf".
 * 
 * Example 2:
 * Given the following words in dictionary,
 * 
 * [
 *   "z",
 *   "x"
 * ]
 * The correct order is: "zx".
 * 
 * Example 3:
 * Given the following words in dictionary,
 * 
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 * The order is invalid, so return "".
 */
import java.util.*;
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(a.charAt(j))) {
                        set = map.get(a.charAt(j));
                    }
                    if (!set.contains(b.charAt(j))) {
                        set.add(b.charAt(j));
                        degree.put(b.charAt(j), degree.get(b.charAt(j)) + 1);
                        map.put(a.charAt(j), set);
                    }
                    break; 
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) queue.add(entry.getKey());
        }
        String res = "";
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            res += cur;
            if (!map.containsKey(cur)) continue;
            Set<Character> set = map.get(cur);
            for (char str : set) {
                degree.put(str, degree.get(str) - 1);
                if (degree.get(str) == 0) queue.add(str);
            }
        }
        return res.length() == degree.size() ? res : "";
    }
}