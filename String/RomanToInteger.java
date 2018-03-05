/**
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Given a roman numeral, convert it to an integer.
 */
import java.util.*;
 public class RomanToInteger {
     public int solution(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                res += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            }
            else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
     }
 }