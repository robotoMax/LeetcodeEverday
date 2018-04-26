/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division 
 * should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */
import java.util.*;
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isDigit(a)) {
                num = num * 10 + a - '0';
            }
            if (!Character.isDigit(a) && a != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = a;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}