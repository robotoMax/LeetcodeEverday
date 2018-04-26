/**
 * 就是一堆coin，让你找所有可能的sum
 */
import java.util.*;
public class CombinationOfCoins {
    public Set<Integer> solution(int[] coins) {
        Set<Integer> res = new HashSet<>();
        if (coins == null || coins.length == 0) return res;
        Arrays.sort(coins);
        helper(res, coins, 0, 0);
        return res;
    }
    public void helper(Set<Integer> res, int[] coins, int cur, int pos) {
        if (pos == coins.length) return;
        for (int i = pos; i < coins.length; i++) {
            res.add(cur + coins[i]);
            helper(res, coins, cur + coins[i], i + 1);
        }
        return;
    }
    public static void main(String[] args) {
        CombinationOfCoins c = new CombinationOfCoins();
        int[] coins = {1,1,3};
        System.out.println(c.solution(coins).toString());
    }
}