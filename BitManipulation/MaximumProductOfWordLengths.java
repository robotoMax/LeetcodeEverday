/**
 * 
 * Date: 03/30/2018
 * Created By: Shuai Liu
 * 
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share 
 * common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * 
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * 
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] bytes = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (char c : words[i].toCharArray()) {
                val |= 1 << (c - 'a');
            }
            bytes[i] = val;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}