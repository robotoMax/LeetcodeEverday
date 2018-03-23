/**
 * 
 * Date: 03/22/2018
 * Created By: Shuai Liu
 * 
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,
 * k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
import java.util.*;
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
                countStack.push(count);
            }
            else if (s.charAt(i) == '[') {
                stringStack.push(res);
                res = "";
                i++;
            }
            else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(stringStack    .pop());
                int times = countStack.pop();
                for (int j = 0; j < times; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }
            else res += s.charAt(i++);
        }
        return res;
    }
}