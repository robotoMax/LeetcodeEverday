/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * Given a string and a string dictionary, find the longest string in the dictionary that 
 * can be formed by deleting some characters of the given string. If there are more than one possible results, 
 * return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * 
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 */
import java.util.*;
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) return "";
        String res = "";
        for (String str : d) {
            if (str.length() > s.length()) continue;
            int pos = 0;
            for (int i = 0; i < s.length() && pos < str.length(); i++) {
                if (s.charAt(i) == str.charAt(pos)) pos++;
            }
            if (pos == str.length() && str.length() >= res.length()) {
                if (str.length() > res.length() || str.compareTo(res) < 0) {
                    res = str;
                }
            }
        }
        return res;
    }
}