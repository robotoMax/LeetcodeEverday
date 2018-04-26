/**
 * 
 * Date: 04/13/2018
 * Created By: Shuai Liu
 * 
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the 
 * substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one p
 * air of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * 
 * Example 1:
 * Input: 
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * Example 2:
 * Input: 
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * Note:
 * 1. The given dict won't contain duplicates, and its length won't exceed 100.
 * 2, All the strings in input have length in range [1, 1000].
 */
public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String str : dict) {
                if (s.startsWith(str, i)) {
                    end = Math.max(end, i + str.length());
                }
            }
            bold[i] = i < end;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bold.length; i++) {
            if (!bold[i]) sb.append(s.charAt(i));
            else {
                sb.append("<b>");
                int j = i;
                while (j < s.length() && bold[j]) j++;
                sb.append(s.substring(i, j));
                sb.append("</b>");
                i = j - 1;
            }
        }
        return sb.toString();
    }
}