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
public class AddTwoNumberString {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int sum = 0;
        while (len1 >= 0 || len2 >= 0) {
            if (len1 >= 0) {
                sum += num1.charAt(len1) - '0';
                len1--;
            }
            if (len2 >= 0) {
                sum += num2.charAt(len2) - '0';
                len2--;
            }
            int num = sum % 10;
            sb.insert(0, num);
            sum /= 10;
        }
        if (sum == 1) sb.insert(0, 1);
        return sb.toString();
    }
}