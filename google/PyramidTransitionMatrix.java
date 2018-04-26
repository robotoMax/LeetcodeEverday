/**
 * 
 * Date: 04/19/2018
 * Created By: Shuai Liu
 * 
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.
 * For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. 
 * We are allowed to place the block there only if `(A, B, C)` is an allowed triple.
 * 
 * We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed 
 * triple is represented as a string of length 3.
 * 
 * Return true if we can build the pyramid all the way to the top, otherwise false.
 * 
 * Example 1:
 * Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 *     A
 *    / \
 *   D   E
 *  / \ / \
 * X   Y   Z
 * This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
 * Example 2:
 * Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 * Note:
 * 1. bottom will be a string with length in range [2, 8].
 * 2. allowed will have length in range [0, 200].
 * 3. Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
import java.util.*;
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : allowed) {
            String key = str.substring(0, 2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str.substring(2));
        }
        return helper(bottom, map);
    }
    public boolean helper(String bot, Map<String, List<String>> map) {
        if (bot.length() == 1) return true;
        for (int i = 0; i < bot.length() - 1; i++) {
            if (!map.containsKey(bot.substring(i, i + 2))) return false;
        }
        List<String> next = new ArrayList<>();
        getList(bot, map, next, 0, "");
        for (String newBot : next) {
            if (helper(newBot, map)) return true;
        }
        return false;
    }
    public void getList(String bot, Map<String, List<String>> map, List<String> list, int pos, String temp) {
        if (pos == bot.length() - 1) {
            list.add(temp);
            return;
        }
        for (String s : map.get(bot.substring(pos, pos + 2))) {
            getList(bot, map, list, pos + 1, temp + s);
        }
    }
}