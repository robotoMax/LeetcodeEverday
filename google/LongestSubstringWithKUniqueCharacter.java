public class LongestSubstringWithKUniqueCharacter {
    public String solution(String str, int k) {
        if (str == null || str.length() == 0) return "";
        int[] cache = new int[256];
        String res = "";
        int len = 0;
        int count = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cache[c] == 0) count++;
            cache[c]++;
            while (count > k) {
                if (cache[left] > 0) count--;
                cache[left]--;
                left++;
            }
            if (i - left + 1 > len) {
                len = i - left + 1;
                res = str.substring(left, i + 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LongestSubstringWithKUniqueCharacter l = new LongestSubstringWithKUniqueCharacter();
        String str = "eceba";
        int k = 2;
        System.out.println(l.solution(str, k));
    }
}