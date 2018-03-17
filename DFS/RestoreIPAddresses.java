/**
 * 
 * Date: 03/16/2018
 * Created By: Shuai Liu
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.*;
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12) return res;
        helper(s, res, "", 0, 0);
        return res;
    }
    public void helper(String s, List<String> res, String temp, int pos, int count) {
        if (count == 4 && pos == s.length()) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i + pos <= s.length()) {
                String str = s.substring(pos, pos + i);
                if (!valid(str)) continue;
                helper(s, res, temp + str + '.', pos + i, count + 1);
            }
        }
    }
    public boolean valid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 255;
    }
}