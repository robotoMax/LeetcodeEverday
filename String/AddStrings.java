/**
 * 
 * Date: 03/23/2018
 * Created By: Shuai Liu
 * 
 * most significant digit is on the right.
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (len1 > 0 || len2 > 0) {
            if (len1 > 0) sum += num1.charAt(--len1) - '0';
            if (len2 > 0) sum += num2.charAt(--len2) - '0';
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum == 1) sb.append(sum);
        return sb.reverse().toString();
    }
}