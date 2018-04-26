/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 *  
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and 
 * return the shortest palindrome you can find by performing this transformation.
 * 
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
/**
 * for instance: 
 * input: abcd
 * first: the intuitive way is we add all to the front: bcdaabcd. however, we can remove one 'a' to make like this:
 * bcdabcd.
 * 
 * So using KMP is the way to find the same prefix and suffix.
 * For instance, input is abacd. The intuitive way is to put all the string in the front dcabaabacd.
 * Using our method, the same aba can be removed. Then, it looks like dcabacd. 
 * 
 * So KMP is just remove the same prefix and suffix by first reverse the string and append to the original one.
 * making abcd to abcd#dcba. Using this way, we can find the same characters.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = KMP(temp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    public int[] KMP(String temp) {
        int[] res = new int[temp.length()];
        int i = 1;
        int index = 0;
        while (i < temp.length()) {
            if (temp.charAt(i) == temp.charAt(index)) {
                res[i] = index + 1;
                i++;
                index++;
            }
            else {
                if (index != 0) {
                    index = res[index - 1];
                }
                else i++;
            }
        }
        return res;
    }
}