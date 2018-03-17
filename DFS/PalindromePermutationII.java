/**
 * 
 * Date: 03/14/2018
 * Created By: Shuai Liu
 * 
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list 
 * if no palindromic permutation could be form.
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
import java.util.*;
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        String mid = "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 == 1) {
                mid += key;
            }
            for (int i = 0; i < val / 2; i++) sb.append(key);
        }
        if (mid.length() > 1) return res;
        boolean[] visited = new boolean[sb.length()];
        helper(res, sb.toString(), mid, new StringBuilder(), visited);
        return res;
    }
    public void helper(List<String> res, String str, String mid, StringBuilder sb, boolean[] visited) {
        if (sb.length() == str.length()) {
            String temp = sb.toString();
            res.add(temp + mid + new StringBuilder().append(temp).reverse().toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((i > 0 && str.charAt(i - 1) == str.charAt(i) && !visited[i - 1]) || visited[i]) continue;
            visited[i] = true;
            sb.append(str.charAt(i));
            helper(res, str, mid, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
        return;
    }
}