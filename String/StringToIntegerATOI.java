/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Need to be careful of the sign, out of the boundary, not valid character
 * 
 * Implement atoi to convert a string to an integer.
 */
public class StringToIntegerATOI {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int sign = 1;
        int start = 0;
        long res = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '+') start++;
        else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}