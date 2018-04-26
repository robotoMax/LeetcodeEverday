/**
 * Given a grid with width and height, start point, end point. You can only go these directions (i + 1, j), (i + 1,  j - 1), 
 * (i + 1, j + 1). How many ways from start to the end.
 */
import java.util.*;
public class StartToEndRoad {
    int[][] dir = {{1, 0}, {1, -1}, {1, 1}};
    int res = 0;
    public int solution(int width, int height, int[] start, int[] end) {
        helper(width, height, start[0], start[1], end[0], end[1]);
        return res;
    }
    public void helper(int w, int h, int i, int j, int x, int y) {
        if (x == i && y == j) {
            res++;
            return;
        }
        for (int[] d : dir) {
            int row = i + d[0];
            int col = j + d[1];
            if (row >= 0 && row < h && col >= 0 && col < w) {
                // System.out.println("row: " + row + " col: " + col);
                helper(w, h, row, col, x, y);
            }
        }
    }
    public static void main(String[] args) {
        StartToEndRoad s = new StartToEndRoad();
        int width = 6;
        int height = 6;
        int[] start = {1,2};
        int[] end = {5, 4};
        System.out.println(s.solution(width, height, start, end));
    }
    // follow up: if you have a list of points, what is the routes from the starting point to the ending points through those points?
    // public List<int[]> solution(int width, int height, int[] start, int[] end, List<int[]> points) {


    // }
}