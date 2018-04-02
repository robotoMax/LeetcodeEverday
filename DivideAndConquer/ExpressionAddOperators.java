/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary 
 * operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * 
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */
import java.util.*;
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, num, target, "", 0, 0, 0);
        return res;
    }
    public void helper(List<String> res, String num, int target, String temp, int pos, long cur, long mul) {
        if (cur == target && pos == num.length()) {
            res.add(temp);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') continue;
            long n = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, num, target, temp + n, i + 1, n, n);
            }
            else {
                helper(res, num, target, temp + "+" + n, i + 1, cur + n, n);
                helper(res, num, target, temp + "-" + n, i + 1, cur - n, -n);
                helper(res, num, target, temp + "*" + n, i + 1, cur - mul + mul * n, mul * n);
            }
        }
        return;
    }
}