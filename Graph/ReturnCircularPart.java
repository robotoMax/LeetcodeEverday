/**
 * 
 */
import java.util.*;
public class ReturnCircularPart {
    // have n vertices
    public List<Integer> solution(int[][] edges, int n) {
        List<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0) return res;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>(); // 0 -> unvisited, 1 -> visiting, 2 -> visited
        for (int i = 0; i < n; i++) visited.put(i, 0);
        for (int[] e : edges) {
            if (!graph.containsKey(e[0])) graph.put(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
        }
        int circle = helper(graph, visited, 0, res,  - 1);

        return res;
    }
    public Integer helper(Map<Integer, List<Integer>> graph, Map<Integer, Integer> visited, int start, List<Integer> list, int pre) {
        if (!graph.containsKey(start)) return -1;
        List<Integer> next = graph.get(start);
        visited.put(start, 1);
        int res = 0;
        for (int neighbor : next) {
            if (visited.get(neighbor) == 2) continue;
            list.add(neighbor);
            if (visited.get(neighbor) == 1 && neighbor != pre) {
                return neighbor;
            }
            list.remove(list.size() - 1);
            res = helper(graph, visited, neighbor, list, start);
        }
        visited.put(start, 2);
        return res;
    }
    public static void main(String[] args) {
        ReturnCircularPart r = new ReturnCircularPart();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {2,4}, {4,1}};
        System.out.println(r.solution(edges, 5).toString());
    }
}