/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * We are given N different types of stickers. Each sticker has a lowercase English word on it.
 * You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
 * You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
 * What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
 * 
 * Example 1:
 * 
 * Input:
 * ["with", "example", "science"], "thehat"
 * Output:
 * 3
 * Explanation:
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target string.
 * Example 2:
 * Input:
 * ["notice", "possible"], "basicbasic"
 * Output:
 * -1
 * Explanation:
 * We can't form the target "basicbasic" from cutting letters from the given stickers.
 * Note:
 * 
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English letters.
 * In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
 * The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.
 */
/**
 * similar with coin change
 */
import java.util.*;
public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        return helper(mp, target, dp);
    }
    public int helper(int[][] mp, String target, Map<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);           
        }
        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i][target.charAt(0) - 'a'] == 0) continue; // find the one that contians the first character of target
            StringBuilder next = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                    next.append((char)('a' + j));                    
                }
            }
            int temp = helper(mp, next.toString(), dp);
            if (temp != -1) {
                res = Math.min(res, temp + 1);
            }
        }
        dp.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return dp.get(target);
    }
}