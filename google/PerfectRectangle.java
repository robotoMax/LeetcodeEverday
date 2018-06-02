/**
 * Date: 05/31/2018
 * Created By: Shuai Liu
 * 
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * 
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as 
 * [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 * 
 * Example 1:
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [3,2,4,4],
 *   [1,3,2,4],
 *   [2,3,3,4]
 * ]
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 * 
 * Example 2:
 * rectangles = [
 *   [1,1,2,3],
 *   [1,3,2,4],
 *   [3,1,4,2],
 *   [3,2,4,4]
 * ]
 * Return false. Because there is a gap between the two rectangular regions.
 * 
 * Example 3:
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [3,2,4,4]
 * ]
 * Return false. Because there is a gap in the top center.
 * 
 * Example 4:
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [2,2,4,4]
 * ]
 * Return false. Because two of the rectangles overlap with each other.
 */
/**
 * The right answer must satisfy two conditions:
 * 
 * 1. the large rectangle area should be equal to the sum of small rectangles
 * 2. count of all the points should be even, and that of all the four corner points should be one
 */
import java.util.*;
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;
        Set<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            if (!set.add(rect[0] + "," + rect[1])) set.remove(rect[0] + "," + rect[1]);
            if (!set.add(rect[0] + "," + rect[3])) set.remove(rect[0] + "," + rect[3]);
            if (!set.add(rect[2] + "," + rect[1])) set.remove(rect[2] + "," + rect[1]);
            if (!set.add(rect[2] + "," + rect[3])) set.remove(rect[2] + "," + rect[3]);
        }
        if (!set.contains(x1 + "," + y1) || !set.contains(x2 + "," + y1) || !set.contains(x1 + "," + y2) || !set.contains(x2 + "," + y2) || set.size() != 4) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
}