/**
 * Date: 07/15/2018
 * Created By: Shuai Liu
 * 
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the 
 * graph has one node in A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  
 * Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, 
 * and it doesn't contain any element twice.
 * 
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets. 
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !valid(graph, colors, 0, i)) return false;
        }
        return true;
    }
    public boolean valid(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != -1) return colors[node] == color;
        colors[node] = color;
        for (int next : graph[node]) {
            if (!valid(graph, colors, 1 - color, next)) return false;
        }
        return true;
    }
}