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