/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * 
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
/**
 * 1. count the frequence of the strings in the array
 * 2. build a bucket
 * 3. put the strings to its bucket
 * 4. traverse the bucket from back, if bucket isn't null, go through the trie, add the string to the result.
 */
import java.util.*;
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> freq = new HashMap<>();
        Node[] bucket = new Node[words.length + 1];
        for (String str : words) freq.put(str, freq.getOrDefault(str, 0) + 1);
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (bucket[val] == null) bucket[val] = new Node();
            buildTree(bucket[val], key);
        }
        int i = bucket.length - 1;
        while (res.size() < k) {
            if (bucket[i] != null) {
                helper(bucket[i], res, k);
            }
            i--;
        }
        return res;
    }

    public void helper(Node node, List<String> res, int k) {
        if (res.size() == k) return;
        if (node.word != "") {
            res.add(node.word);
        }
        for (int i = 0; i < node.child.length; i++) {
            Node next = node.child[i];
            if (next != null) {
                helper(next, res, k);
            }
        }
        return;
    }

    private class Node {
        Node[] child = new Node[256];
        String word = "";
    }
    public void buildTree(Node node, String str) {
        Node cur = node;
        for (char c : str.toCharArray()) {
            if (cur.child[c] == null) cur.child[c] = new Node();
            cur = cur.child[c];
        }
        cur.word = str;
    }
}
        