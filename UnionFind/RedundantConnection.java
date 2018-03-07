/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * 
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 * 
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * 
 * Time Complexity: O(n)
 * 
 */
public class RedundantConnection {
    
    private class UnionFind {
        int[] root;
        public UnionFind(int n) {
            root = new int[n + 1];
            for (int i = 0; i < root.length; i++) root[i] = i;
        }
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false;
            root[rootV] = rootU;
            return true;
        }
        public int find(int p) {
            while (p != root[p]) {
                root[p] = root[root[p]];
                p = root[p];
            }
            return p;
        }
    }

    public int[] solution(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return edge;
        }
        return new int[0];
    }

}