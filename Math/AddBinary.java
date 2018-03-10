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
        int al = a.length() - 1;
        int bl = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int carry = 0;
        while (al >= 0 || bl >= 0) {
            sum = carry;
            if (al >= 0) {
                sum += a.charAt(al) - '0';
                al--;
            }
            if (bl >= 0) {
                sum += b.charAt(bl) - '0';
                bl--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}