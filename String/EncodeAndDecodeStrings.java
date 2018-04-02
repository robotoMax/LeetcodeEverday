/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and 
 * is decoded back to the original list of strings.
 * 
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * 
 * Implement the encode and decode methods.
 * Note:
 * 1. The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized 
 * enough to work on any possible characters.
 * 2. Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * 3. Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
import java.util.*;
public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length()).append("/").append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int len = Integer.parseInt(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + 1 + len));
            i = slash + 1 + len;
        }
        return res;
    }
}