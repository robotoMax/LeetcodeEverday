/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total 
 * number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern:
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, 
 * the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * 
 * The order of keys used matters.
 * 
 * Explanation:
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6 
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * 
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * 
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 * 
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 * 
 * Example:
 * Given m = 1, n = 1, return 9.
 */
/**
 * coin changes also use int as its helper function returning type
 */
public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int[][] map = new int[10][10];
        map[1][3] = map[3][1] = 2;
        map[4][6] = map[6][4] = 5;
        map[7][9] = map[9][7] = 8;
        map[1][7] = map[7][1] = 4;
        map[3][9] = map[9][3] = 6;
        map[2][8] = map[8][2] = 5;
        map[1][9] = map[9][1] = map[3][7] = map[7][3] = 5;
        int res = 0;
        for (int i = m; i <= n; i++) {
            boolean[] visited = new boolean[10];
            res += helper(map, visited, 1, 1, i) * 4;
            res += helper(map, visited, 2, 1, i) * 4;
            res += helper(map, visited, 5, 1, i);
        }
        return res;
    }
    public int helper(int[][] map, boolean[] visited, int cur, int count, int move) {
        if (count == move) return 1;
        visited[cur] = true;
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (0 == map[cur][i] || visited[map[cur][i]])) {
                result += helper(map, visited, i, count + 1, move);
            }
        }
        visited[cur] = false;
        return result;
    }
}