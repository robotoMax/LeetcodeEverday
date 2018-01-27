/*
* Author: Shuai Liu
* Date: 01/26/2018 21:04
* Note: We can use Union Find and DFS to find the cycle of the graph. This version is using DFS
* 261
* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
* write a function to check whether these edges make up a valid tree.
* For example:
* Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
* Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
* Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
* [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
import java.util.*;
public class GraphValidTree{
    public static boolean solution(int n, int[][] edges) {
        List<List<Integer>> adList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adList.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            adList.get(edge[0]).add(edge[1]);
            adList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(adList, 0, visited, -1)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean hasCycle(List<List<Integer>> adList, int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int i = 0; i < adList.get(node).size(); i++) {
            int next = adList.get(node).get(i);
            if (visited[next] && parent != next || (!visited[next] && hasCycle(adList, next, visited, node)))
                return true; 
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(solution(5, edges));
    }
}