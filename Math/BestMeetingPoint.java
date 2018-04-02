/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of 
 * values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan 
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */
import java.util.*;
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        return getMin(row) + getMin(col);
    }
    public int getMin(List<Integer> list) {
        Collections.sort(list);
        int res = 0;
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            res += list.get(right--) - list.get(left++);
        }
        return res;
    }
}