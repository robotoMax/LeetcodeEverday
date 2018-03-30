/**
 * 
 * Date: 03/29/2018
 * Created By: Shuai Liu
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of 
 * the two words, i.e. words[i] + words[j] is a palindrome.
 * 
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
import java.util.*;
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String sub1 = words[i].substring(0, j);
                String sub2 = words[i].substring(j);
                if (isPalindrome(sub1)) {
                    String sub2rev = new StringBuilder(sub2).reverse().toString();
                    if (map.containsKey(sub2rev) && map.get(sub2rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(sub2rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (sub2.length() != 0 && isPalindrome(sub2)) {
                    String sub1rev = new StringBuilder(sub1).reverse().toString();
                    if (map.containsKey(sub1rev) && map.get(sub1rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(sub1rev));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}