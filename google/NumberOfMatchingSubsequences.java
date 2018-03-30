/**
 * 
 * Date: 03/28/2018
 * Created By: Shuai Liu
 * 
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 * Example :
 * Input: 
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * 
 * Note:
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 */
import java.util.*;
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        List<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<>();
        }
        for (String str : words) {
            heads[str.charAt(0) - 'a'].add(new Node(str, 0));
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            List<Node> cur = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();
            for (Node node : cur) {
                node.index++;
                if (node.index == node.word.length()) res++;
                else {
                    heads[node.word.charAt(node.index) - 'a'].add(new Node(node.word, node.index));
                }
            }
            cur.clear();
        }
        return res;
    }
    private class Node {
        int index;
        String word;
        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}   