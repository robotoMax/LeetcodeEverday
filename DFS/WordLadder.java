/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.


 */
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    char[] chars = cur.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String next = new String(chars);
                        if (dict.contains(next) && next.equals(endWord)) return level++;
                        if (dict.contains(next) && visited.add(next)) queue.add(next);
                    }
                }
            }
        }
        return 0;
    }
    // using two-end BFS == Bidirectional BFS
    // same as Minimum Genetic Mutation
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        start.add(beginWord);
        if (dict.contains(endWord)) end.add(endWord);
        int level = 1;
        while (!start.isEmpty() && !end.isEmpty()) {
            if (start.size() > end.size()) {
                Set<String> temp = start;
                start = end;
                end = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String str : start) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char a = 'a'; a <= 'z'; a++) {
                        chars[i] = a;
                        String next = new String(chars);
                        if (end.contains(next)) return level + 1;
                        if (dict.contains(next) && visited.add(next)) temp.add(next);
                    }
                    chars[i] = old;
                }
            }
            start = temp;
            level++;
        }
        return 0;
    }    
}