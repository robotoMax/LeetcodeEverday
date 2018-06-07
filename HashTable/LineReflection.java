/**
 * Date: 06/05/2018
 * Created By: Shuai Liu
 * 
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * 
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * Follow up:
 * Could you do better than O(n^2)?
 */
import java.util.*;
public class LineReflection {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) return true;
        Set<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0] + "," + p[1]);
        }
        int sum = max + min;
        for (int[] p : points) {
            if (!set.contains((sum - p[0]) + "," + p[1])) return false;
        }
        return true;
    }
}