/**
 * 遇到b 就刪除前面一個字元  其他就不管
 */
import java.util.*;
public class SimplyStringByCharB {
    public static String solution(String str) {
        if (str == null || str.length() == 0) return "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty() && str.charAt(i) == 'b') {
                stack.pop();
            }
            else stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "acaabaabbb";
        System.out.println(solution(str));
    }
}