/**
 * 输入是n，输出随机生成的玛丽医生的地图（16x8，里面一共有三种颜色的细菌，横向或纵向连续三个格子不能是相同的颜色细菌），地图中有n个细菌。
 * 考有条件生成随机数的。
 */
import java.util.*;
public class MeryBacteriaMap {
    public int[][] solution(int n) {
        int[][] res = new int[8][16];
        int count = 0;
        Random rand = new Random();
        Set<int[]> haveBacteria = new HashSet<>();
        while (count < n) {
            int i = 0;
            int j = 0;
            for (; i < res.length; i++) {
                for (; j < res[0].length; j++) {
                    if (count >= n) return res;
                    int[] pos = {i, j};
                    if (haveBacteria.contains(pos)) continue;
                    List<Integer> list = new ArrayList<>();
                    Integer[] arr = {0, 1, 2, 3};
                    list.addAll(Arrays.asList(arr));
                    while (true) {
                        int index = rand.nextInt(list.size());
                        int cur = list.get(index);
                        if (cur == 0) break;
                        if (check(res, i, j, cur)) {
                            res[i][j] = cur;
                            haveBacteria.add(new int[]{i, j});
                            count++;
                            break;
                        }
                        list.remove(index);
                    }
                }
            }
        }
        return res;
    }
    public boolean check(int[][] map, int x, int y, int color) {
        if ((x - 2 >= 0 && map[x - 2][y] == color && map[x - 1][y] == color)
        || (y - 2 >= 0 && map[x][y - 2] == color && map[x][y - 2] == color)
        || (x + 2 <= map.length - 1 && map[x + 2][y] == color && map[x + 1][y] == color)
        || (y + 2 <= map[0].length - 1 && map[x][y + 2] == color && map[x][y + 1] == color)
        || (x - 1 >= 0 && x + 1 <= map.length - 1 && map[x + 1][y] == color && map[x - 1][y] == color)
        || (y - 1 >= 0 && y + 1 <= map[0].length - 1 && map[x][y - 1] == color && map[x][y + 1] == color)) return false;
        return true;
    }
    public static void main(String[] args) {
        MeryBacteriaMap m = new MeryBacteriaMap();
        int n = 78;
        int[][] res = m.solution(n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}