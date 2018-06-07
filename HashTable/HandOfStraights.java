/**
 * Date: 06/03/2018
 * Created By: Shuai Liu
 * 
 * Alice has a hand of cards, given as an array of integers.
 * 
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive 
 * cards.
 * 
 * Return true if and only if she can.
 * Example 1:
 * 
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * 
 * Example 2:
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * 
 * Note:
 * 1. 1 <= hand.length <= 10000
 * 2. 0 <= hand[i] <= 10^9
 * 3. 1 <= W <= hand.length
 */
import java.util.*;
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) map.put(card, map.getOrDefault(card, 0) + 1);
        for (int card : map.keySet()) {
            if (map.get(card) > 0) {
                for (int i = W - 1; i > 0; i--) {
                    if (map.getOrDefault(card + i, 0) < map.get(card)) return false;
                    map.put(card + i, map.get(card + i) - map.get(card));
                }
            }
        }
        return true;
    }
}