/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means 
 * it can represent any one letter.
 * 
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWordDataStructureDesign {}

class WordDictionary {

    private class Node {
        Node[] child = new Node[256];
        String word = "";
    }

    Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.child[c] == null) node.child[c] = new Node();
            node = node.child[c];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        Node node = root;
        return helper(node, word, 0);
    }

    public boolean helper(Node node, String word, int pos) {
        if (pos == word.length()) return !node.word.equals("");
        char c = word.charAt(pos);
        if (c == '.') {
            for (int i = 0; i < node.child.length; i++) {
                if (node.child[i] == null) continue;
                if (helper(node.child[i], word, pos + 1)) return true;
            }
        }
        else {
            return node.child[c] != null && helper(node.child[c], word, pos + 1);
        }
        return false;
    }
}
