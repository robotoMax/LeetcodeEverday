/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers 
 * and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
import java.util.*;
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if (c == '+') {
                res += num * sign;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                res += num * sign;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (c == ')') {
                res += num * sign; // add whatever inside the parentheses
                res *= stack.pop(); // multiply its sign
                res += stack.pop(); // add whatever before the parentheses
                num = 0;
            }
        }
        if (num != 0) res += sign * num;
        return res;
    }
}