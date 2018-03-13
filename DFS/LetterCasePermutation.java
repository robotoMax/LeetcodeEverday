/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given a string S, we can transform every letter individually to be lowercase or 
 * uppercase to create another string.  Return a list of all possible strings we could create.
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 */
import java.util.*;
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            res.add("");
            return res;
        }
        helper(S, res, 0, new StringBuilder());
        return res;
    }
    public void helper(String s, List<String> res, int cur, StringBuilder temp) {
        if (temp.length() == s.length()) {
            res.add(temp.toString());
            return;
        }
        char c = s.charAt(cur);
        if (Character.isDigit(c)) {
            temp.append(c);
            helper(s, res, cur + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        else {
            for (int j = 0; j < 2; j++) {
                if (j == 0) c = Character.toLowerCase(c);
                if (j == 1) c = Character.toUpperCase(c);
                temp.append(c);
                helper(s, res, cur + 1, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}