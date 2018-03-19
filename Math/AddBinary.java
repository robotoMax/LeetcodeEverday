/**
 * 
 * Date: 03/09/2018
 * Created By: Shuai Liu
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
/**
 * same as add two numbers
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (m >= 0 || n >= 0) {
            if (m >= 0) sum += a.charAt(m--) - '0';
            if (n >= 0) sum += b.charAt(n--) - '0';
            sb.append(sum % 2);
            sum /= 2;
        }
        if (sum == 1) sb.append(1);
        return sb.reverse().toString();
    }
}