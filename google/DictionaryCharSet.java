/**
 * 给一个dict.txt和readline() function，dict.txt中每行是一个英文单词，比如 a, an, the, tank, ten, bet, ant, cut，
 * 给一个char set 比如[a, t, n, e] 返回所有由这个set中char组成的最长单词，set里面每个字母只能用一次， 这个返回就是[”ant”, “ten"] 
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
import java.util.*;
public class DictionaryCharSet {
    /**
     * my method: 
     * 1. build trie tree based on the dict.txt
     * 2. put char set to the hashset
     * 3. DFS trie, for loop every node's child array. If it's not null and it was in hashset, then add to visited hashset and check
     * if the node.string != "". If it's the case, add the string to the result. And traverse further until all the child is null.
     */
    // someone's code
    public List<String> findWords(Set<String> dict, char[] chars) {
        int max = -1;
        int[] freq = new int[256];
        for (char c : chars) {
            freq[c - 'a']++;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : dict) {
            int[] checker = freq.clone();
            int i = 0;
            for (; i < s.length(); i++) {
                int val = s.charAt(i) - 'a';
                checker[val]--;
                if (checker[val] < 0) {
                    break;
                }
            }
            /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
            if (i == s.length()) {
                addToMap(map, s);
                max = Math.max(max, s.length());
            }
        }
        return map.get(max);
    }
}