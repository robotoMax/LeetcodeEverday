/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given a set of words (without duplicates), find all word squares you can build from them.
A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:
Input:
["area","lead","wall","lady","ball"]
Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:
Input:
["abat","baba","atan","atal"]
Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 */
/**
 * using trie to take advantage of the ability of prefix searching
 */
import java.util.*;
public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Node root = new Node();
        buildTree(root, words);
        helper(res, root, new ArrayList<>());
        return res;
    }
    public void helper(List<List<String>> res, Node root, List<String> temp) {
        if (temp.size() > 0 && temp.size() == temp.get(0).length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        int len = temp.size();
        StringBuilder prefix = new StringBuilder();
        for (String str : temp) {
            prefix.append(str.charAt(len)); // find the next word that starts with this prefix.
        }
        for (String str : findByPrefix(root, prefix.toString())) {
            temp.add(str);
            helper(res, root, temp);
            temp.remove(temp.size() - 1);
        }
        return;
    }
    public List<String> findByPrefix(Node root, String str) {
        Node node = root;
        List<String> res = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (node.child[c] == null) return res;
            node = node.child[c];
        }
        res.addAll(node.startsWith); // if str == null, then we can return the all the words stores in root's startsWith list
        return res;
    }
    private class Node {
        List<String> startsWith = new ArrayList<>();
        Node[] child = new Node[256];
    }
    public void buildTree(Node root, String[] words) {
        root.startsWith.addAll(Arrays.asList(words));
        for (String str : words) {
            Node node = root;
            for (char c : str.toCharArray()) {
                if (node.child[c] == null) {
                    node.child[c] = new Node();
                }
                node.child[c].startsWith.add(str);
                node = node.child[c];
            }
        }
    }
}