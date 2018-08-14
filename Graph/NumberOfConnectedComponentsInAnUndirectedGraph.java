/**
 * 
 * Date: 03/09/2018
 * Created By: Shuai Liu
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * 
 * Example 1:
 *      0          3
 *      |          |
 *      1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 
 * Example 2:
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
import java.util.*;
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            helper(graph, visited, i);
            res++;
        }
        return res;
    }
    public void helper(List<List<Integer>> graph, boolean[] visited, int cur) {
        if (visited[cur]) return;
        visited[cur] = true;
        List<Integer> list = graph.get(cur);
        for (int a : list) {
            helper(graph, visited, a);
        }
    }
    // using Union find:
    public int countComponents1(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
        for (int[] e : edges) {
            int p1 = find(roots, e[0]);
            int p2 = find(roots, e[1]);
            if (p1 != p2) {
                roots[p1] = p2;
                n--;
            }
        }
        return n;
    }
    public int find(int[] roots, int id) {
        int par = roots[id];
        while (par != roots[par]) {
            par = roots[par];
        }
        return par;
    }
}