/**
 * 
 * Date: 04/11/2018
 * Created By: Shuai Liu
 * 
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs,
 * determine if two sentences are similar.
 * 
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar 
 * word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * 
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good"
 * are similar, then "great" and "fine" are similar.
 * 
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * 
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] 
 * are similar, even though there are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] 
 * can never be similar to words2 = ["doubleplus","good"].
 * Note:
 * 1. The length of words1 and words2 will not exceed 1000.
 * 2. The length of pairs will not exceed 2000.
 * 3. The length of each pairs[i] will be 2.
 * 4. The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
// undirected graph. 

import java.util.*;
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] p : pairs) {
            if (!graph.containsKey(p[0])) graph.put(p[0], new HashSet<>());
            if (!graph.containsKey(p[1])) graph.put(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            if (helper(graph, words1[i], words2[i], new HashSet<>())) continue;
            else return false;
        }
        return true;
    }
    public boolean helper(Map<String, Set<String>> graph, String a, String b, Set<String> visited) {
        if (a.equals(b)) return true;
        if (!visited.add(a)) return false;
        if (!graph.containsKey(a)) return false;
        Set<String> next = graph.get(a);
        for (String s : next) {
            if (helper(graph, s, b, visited)) return true;
        }
        return false;
    }
}