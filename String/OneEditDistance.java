/**
 * 
 * Date: 03/22/2018
 * Created By: Shuai Liu
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (Math.abs(len1 - len2) > 1) return false;
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (len1 == len2) return s.substring(i + 1).equals(t.substring(i + 1));
                if (len1 > len2) return s.substring(i + 1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return false;
    }
}