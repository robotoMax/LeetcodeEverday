/**
 * Given a long string, and a string array, you need to return the index of the long string where the pattern appears. If there are
 * multiple appearance, you can return whichever you want.
 * Assume every pattern has same length;
 */
// wrong!!!!! 
// don't finish debuging.
import java.util.*;
public class RabinKarp {
    private static final int PRIME = 3;
    public List<Integer> solution(String longString, String[] pattern) {
        List<Integer> res = new ArrayList<>();
        Map<Long, String> hashmap = new HashMap<>();
        int len = pattern[0].length();
        for (String str : pattern) {
            long hash = getHash(str, 0, str.length() - 1);
            hashmap.put(hash, str);
        }
        long textHash = getHash(longString, 0, len - 1);
        for (int i = 1; i <= longString.length() - len + 1; i++) {
            if (hashmap.containsKey(textHash) && checkEquals(hashmap.get(textHash), longString.substring(i, i + len), 0, len - 1, i, i + len - 1)) {
                res.add(i - 1);
            }
            if (i < longString.length() - len + 1) {
                textHash = recalculateHash(longString.substring(i - 1, i + len), textHash, 0, 1, len - 1);
            }
        }
        return res;
    }
    public long getHash(String a, int start, int end) {
        long hashcode = 0;
        for (int i = 0; i < end - start + 1; i++) {
            hashcode += a.charAt(i) * Math.pow(PRIME, i);
        }
        return hashcode;
    }
    public long recalculateHash(String a, long oldHash, int pre, int cur, int end) {
        int length = end - cur + 1;
        oldHash -= a.charAt(pre);
        oldHash /= PRIME;
        oldHash += a.charAt(end) * Math.pow(PRIME, length - 1);
        return oldHash;
    }
    public boolean checkEquals(String a, String b, int i, int j, int x, int y) {
        if (j - i != y - x) return false;
        while (i <= j && x <= y) {
            if (a.charAt(i) != b.charAt(x)) return false;
            x++;
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        RabinKarp r = new RabinKarp();
        String longString = "abcdef";
        String[] pattern = {"bc"};
        System.out.println(r.solution(longString, pattern).toString());
    }
}