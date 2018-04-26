/**
 * 
 * Date: 04/10/2018
 * Created By: Shuai Liu
 * 
 * Given two strings, get the difference of this two. A >= B
 */
public class TwoStringDifference {
    public String solution(String A, String B) {
        if (A.equals(B)) return "0";
        String res = "";
        int carry = 0;
        int alen = A.length();
        int blen = B.length();                                                                                                                                                                                                      
        int diff = alen - blen;
        for (int i = blen - 1; i >= 0; i--) {
            int sub = A.charAt(i + diff) - B.charAt(i) - carry;
            if (sub < 0) {
                sub += 10;
                carry = 1;
            }
            else carry = 0;
            res = sub + res;
        }

        for (int i = alen - blen - 1; i >= 0; i--) {
            if (A.charAt(i) == '0' && carry == 1) {
                res = "9" + res;
                continue;
            }
            int sub = A.charAt(i) - '0' - carry;
            if (i > 0 || sub > 0) res = sub + res;
            carry = 0;
        }
        return res;
    }
    public static void main(String[] args) {
        String A = "1000";
        String B = "999";
        TwoStringDifference t = new TwoStringDifference();
        System.out.println(t.subtraction(A, B));
    }
}