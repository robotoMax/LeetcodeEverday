/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a 
 * non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters 
 * separated by a single space.
 */
import java.util.*;
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Object, Object> map = new HashMap<>();
        if (strs.length != pattern.length()) return false;
        for (Integer i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            if (map.put(c, i) != map.put(strs[i], i)) return false;
        }
        return true;
    }
}