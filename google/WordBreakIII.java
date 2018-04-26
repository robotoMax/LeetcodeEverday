/**
 * 
 * Date: 04/12/2018
 * Created By: Shuai Liu
 * 
 * just return how many ways to break the string.
 */
import java.util.*;
public class WordBreakIII {
    // dict is morse code
    int res = 0;
    public int solution(String s, List<String> dict) {
        if (s == null || s.length() == 0) return 0;
        helper(s, dict, 0);
        return res;
    }
    public void helper(String s, List<String> dict, int pos) {
        if (pos == s.length()) {
            res++;
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String str = s.substring(pos, i + 1);
            if (dict.contains(str)) {
                System.out.println(str);
                helper(s, dict, i + 1);
            }
        }
        return;
    }
    public static void main(String[] args) {
        String s = "dogplayinthewaterwithcats";
        String[] strs = {"dogs", "dog", "play", "int", "in", "the", "s", "water", "with","cat","cats"};
        List<String> dict = Arrays.asList(strs);
        WordBreakIII w = new WordBreakIII();
        System.out.println(w.solution(s, dict));
    }
}