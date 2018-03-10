/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
import java.util.*;
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int cur = edge[0];
            int next = edge[1];
            graph.get(cur).add(next);
            graph.get(next).add(cur);
        }
        boolean[] visited = new boolean[n];
        if (hasCicle(0, graph, visited, -1)) return false;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    public boolean hasCicle(int cur, List<List<Integer>> graph, boolean[] visited, int parent) {
        visited[cur] = true;
        List<Integer> list = graph.get(cur);
        for (int next : list) {
            if ((visited[next] && parent != next) || (!visited[next] && hasCicle(next, graph, visited, cur))) {
                return true;
            }
        }
        return false;
    }
}