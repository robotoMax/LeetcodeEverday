/**
 * 给定一组char，包含({.小括号
 * Eg. : a(b(c){2}){2}d will be decompressed as abccbccd.
 * {}中间的是前面（）里的内容的重复次数。
 * 
 * 思路用栈，所有的往栈里压，直到），开始把上一个（之后的全部弹出到栈外，然后乘以倍数，然后翻转，再重新压到栈里，然后直到最后，
 * 全都弹出栈，翻转，就是结果了。
 */
import java.util.*;
public class ParenBracketDecompress {
    public String solution(String str) {
        if (str == null || str.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (!c.equals(")")) {
                stack.push(c);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int times = 1;
            if (str.charAt(i + 1) == '{') {
                int count = 0;
                i += 2;
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                times = count;
            }
            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                String a = stack.pop();
                sb.append(a);
            }
            String cur = sb.toString();
            sb = new StringBuilder();
            for (int k = 1; k <= times; k++) {
                sb.append(cur);
            }
            cur = sb.reverse().toString();
            stack.pop(); // pop out "("
            stack.push(cur);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ParenBracketDecompress p = new ParenBracketDecompress();
        String str = "a(b(c)){2}d";
        System.out.println(p.solution(str));
    }
}