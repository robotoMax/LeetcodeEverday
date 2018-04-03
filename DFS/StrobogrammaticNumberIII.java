/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 * Note:
 * Because the range might be a large number, the low and high numbers are represented as string.
 */
public class StrobogrammaticNumberIII {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == low || Long.compare(Long.parseLong(low), Long.parseLong(high)) > 0) return 0;
        int res = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            res += helper(low, high, new char[i], 0, i - 1);
        }
        return res;
    }
    public int helper(String low, String high, char[] temp, int left, int right) {
        if (left > right) {
            String a = new String(temp);
            if (Long.compare(Long.parseLong(a), Long.parseLong(high)) > 0 
            || Long.compare(Long.parseLong(a), Long.parseLong(low)) < 0) return 0;
            else return 1;
        }
        int res = 0;
        for (char[] p : pairs) {
            temp[left] = p[0];
            temp[right] = p[1];
            if (temp.length != 1 && temp[0] == '0') continue;
            if (left == right && (p[0] == '6' || p[0] == '9')) continue;
            res += helper(low, high, temp, left + 1, right - 1);
        }
        return res;
    }
}