/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
// bucket sort
// similar with top k frequent elements
import java.util.*;
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (bucket[val] == null) bucket[val] = new ArrayList<>();
            bucket[val].add(key);
        }
        StringBuilder sb = new StringBuilder();
        int i = bucket.length - 1;
        for (int j = i; j >= 0; j--) {
            if (bucket[j] != null) {
                for (char c : bucket[j]) {
                    for (int p = 0; p < j; p++) sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}