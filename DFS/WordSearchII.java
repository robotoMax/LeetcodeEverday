/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 *  * ]
 * Return ["eat","oath"].
 */
import java.util.*;
public class WordSearchII {

    private class Node {
        Node[] child= new Node[26];
        String word = "";
    }

    public void buildTree(Node root, String[] words) {
        for (String str : words) {
            Node cur = root;
            for (char c : str.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new Node();
                }
                cur = cur.child[c - 'a'];
            }
            cur.word = str;
        }
        return;
    }
    boolean[][] visited;
    int[][] dirc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) return new ArrayList<>();
        Node root = new Node();
        buildTree(root, words);
        visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.child[board[i][j] - 'a'] == null) continue;
                helper(board, root, res, i, j);
            }
        }
        return res;
    }
    public void helper(char[][] board, Node root, List<String> res, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || root.child[board[i][j] - 'a'] == null) return;
        visited[i][j] = true;
        Node next = root.child[board[i][j] - 'a'];
        if (next.word != "") {
            res.add(next.word);
            next.word = "";
        }
        for (int[] dir : dirc) {
            int x = i + dir[0];
            int y = j + dir[1];
            helper(board, next, res, x, y);
        }
        visited[i][j] = false;
        return;
    }
}