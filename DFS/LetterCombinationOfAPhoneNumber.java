/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.*;
public class LetterCombinationOfAPhoneNumber {
    public List<String> solution(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] table = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(res, digits, table, 0, "");
        return res;
    }
    public void helper(List<String> res, String digits, String[] table, int pos, String temp) {
        if (pos == digits.length()) {
            if (!temp.isEmpty()) res.add(temp);
            return;
        }
        int cur = digits.charAt(pos) - '0';
        String str = table[cur];
        for (int i = 0; i < str.length(); i++) {
            helper(res, digits, table, pos + 1, temp + str.charAt(i));
        }
        return;
    }
    public static void main(String[] args) {
        LetterCombinationOfAPhoneNumber l = new LetterCombinationOfAPhoneNumber();
        String digits = "34";
        System.out.println(l.solution(digits));
    }
}