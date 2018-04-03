/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 */
import java.util.*;
public class StrobogrammaticNumberII {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(res, new char[n], 0, n - 1);
        return res;
    }
    public void helper(List<String> res, char[] temp, int left, int right) {
        if (left > right) {
            res.add(new String(temp));
            return;
        }
        for (char[] p : pairs) {
            temp[left] = p[0];
            temp[right] = p[1];
            if (temp.length != 1 && temp[0] == '0') continue;
            if (left == right && (p[0] == '6' || p[0] == '9')) continue;
            helper(res, temp, left + 1, right - 1);
        }
    }
}