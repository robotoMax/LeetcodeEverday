/**
 * 假设trie树已经建好了，给一个prefix，返回所有word
 * follow up: 返回top 5???????? minheap????
 */
import java.util.*;
public class TrieReturnPrefixWord {
    private static class TrieNode {
        String word = "";
        TrieNode[] child = new TrieNode[256];
    }
    public List<String> findAllPrefixWord(String prefix, TrieNode root) {
        List<String> res = new ArrayList<>();
        if (prefix == null || prefix.length() == 0) return res;
        TrieNode node = findTheLastCharNode(prefix, root, 0);
        helper(node, res);
        return res;
    }
    public TrieNode findTheLastCharNode(String str, TrieNode root, int pos) {
        if (pos == str.length()) return root;
        char c = str.charAt(pos);
        TrieNode node = findTheLastCharNode(str, root.child[c], pos + 1);
        return node;
    }
    public void helper(TrieNode node, List<String> res) {
        if (node.word != "") res.add(node.word);
        for (int i = 0; i < node.child.length; i++) {
            if (node.child[i] == null) continue;
            helper(node.child[i], res);
        }
        return;
    }
    public void buildTree(TrieNode root, String[] words) {
        for (String str : words) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                if (node.child[c] == null) node.child[c] = new TrieNode();
                node = node.child[c];
            }
            node.word = str;
        }
        return;
    }
    public static void main(String[] args) {
        TrieReturnPrefixWord t = new TrieReturnPrefixWord();
        TrieNode root = new TrieNode();
        String[] words = {"abc", "a", "def", "abcdef", "cat", "string", "stringcharacter", "abcdefed", "leetcode", "lee", "love", "china", "usa", "Google", "leet", "cat love fish", "dog", "doggy", "java"};
        t.buildTree(root, words);
        System.out.println(t.findAllPrefixWord("cat", root).toString());
    }
}