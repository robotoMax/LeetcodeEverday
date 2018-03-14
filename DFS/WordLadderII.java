/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation 
 * sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
import java.util.*;
public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < str.length(); j++) {
                    char[] c = str.toCharArray();
                    for (char a = 'a'; a <= 'z'; a++) {
                        c[j] = a;
                        String newStr = new String(c);
                        if (unvisited.contains(newStr)) {
                            if (visited.add(newStr)) {
                                queue.add(newStr);
                            }
                            // we can use father as key, and all its children as value in the list.
                            // however, it would be some corner case that cannot be solved.
                            // for example: start = "a", end = "c", wordList = {"a", "b", "c"};
                            // map will have: key: a, list: a, b, c.
                            // in dfs phase, a will always add "a" to the temp. And it will cause stack over flow.
                            List<String> temp = map.getOrDefault(newStr, new ArrayList<>());
                            temp.add(str);
                            map.put(newStr, temp);
                            if (newStr.equals(endWord) && !found) {
                                found = true;
                            }
                        }
                    }
                }
            }
            if (found) break;
            unvisited.removeAll(visited);
            visited.clear();
        }
        helper(res, map, endWord, beginWord, new ArrayList<>());
        return res;
    }
    public static void helper(List<List<String>> res, Map<String, List<String>> map, String word, String start, List<String> temp) {
        if (word.equals(start)) {
            temp.add(0, word);
            res.add(new ArrayList<>(temp));
            temp.remove(0);
            return;
        }
        temp.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                helper(res, map, s, start, temp);
            }
        }
        temp.remove(0);
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList1 = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(wordList1));
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        for (List a : res) {
            System.out.println(a.toString());
        }
    }
}

