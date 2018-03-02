import java.util.*;
class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            char S = s.charAt(j);
            map.put(S, map.getOrDefault(S, 0) + 1);
            if (map.get(S) == 1) count++;
            while (count > k) {
                int num = map.get(s.charAt(i));
                num--;
                if (num == 0) {
                    count--;
                    map.remove(s.charAt(i));
                }
                else map.put(s.charAt(i), num);
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
            
        }
        return res;
    }

    public static void main(String[] args) {
        Test t = new Test();
        String s = "eceba";
        int k = 2;
        System.out.println(t.lengthOfLongestSubstringKDistinct(s, k));
    }
}