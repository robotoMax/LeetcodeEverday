/**
 * Date: 06/07/2018
 * Created By: Shuai Liu
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Note:
 * The vowels does not include the letter "y".
 */
import java.util.*;
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (set.contains(Character.toLowerCase(chars[i])) && set.contains(Character.toLowerCase(chars[j]))) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            else if (!set.contains(Character.toLowerCase(chars[i]))) i++;
            else if (!set.contains(Character.toLowerCase(chars[j]))) j--;
        }
        return new String(chars);
    }
}