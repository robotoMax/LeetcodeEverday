/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 */
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] pre) {
        if (pre == null || pre.length == 0) return true;
        int[] degree = new int[numCourses];
        for (int[] p : pre) {
            degree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            count++;
            for (int[] course : pre) {
                if (course[1] == p) {
                    degree[course[0]]--;
                    if (degree[course[0]] == 0) queue.add(course[0]);
                }
            }
        }
        return count == numCourses;
    }
}