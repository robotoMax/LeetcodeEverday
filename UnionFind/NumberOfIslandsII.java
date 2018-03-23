/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
import java.util.*;
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] p : positions) {
            int root = p[0] * n + p[1];
            roots[root] = root;
            count++;
            for (int[] d : dir) {
                int i = p[0] + d[0];
                int j = p[1] + d[1];
                int id = i * n + j;
                if (i < 0 || i >= m || j < 0 || j >= n || roots[id] == -1) continue;
                int nearRoot = findComponent(roots, id);
                if (nearRoot != root) {
                    roots[nearRoot] = root;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    public int findComponent(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] =roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}