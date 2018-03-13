/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", 
 * "1o2", "2r1", "3d", "w3", "4"]
 */
import java.util.*;
 public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(word, res, 0, 0, "");
        return res;
    }
    public void helper(String word, List<String> res, int count, int pos, String temp) {
        if (pos == word.length()) {
            if (count > 0) temp += count;
            res.add(temp);
            return;
        }
        helper(word, res, count + 1, pos + 1, temp);
        helper(word, res, 0, pos + 1, temp + (count > 0 ? count : "") + word.charAt(pos));
    }
}