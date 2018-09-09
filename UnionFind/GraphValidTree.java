/*
* Author: Shuai Liu
* Date: 01/26/2018 21:04
* Note: We can use Union Find and DFS to find the cycle of the graph. This version is using Union Find
* 261
* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
* write a function to check whether these edges make up a valid tree.
* For example:
* Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
* Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
* Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
* [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
// time complexity: O(V*E) -> let's say the graph has V vertices and E edges, the find( ) function takes O(V) time because 
// in the worst case it has to go through all the vertices, and from outside we loop through all the edges, so the time complexity 
// should be O(V*E).
import java.util.*;
public class GraphValidTree{
    public static boolean validTree(int n, int[][] edges) {
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for (int[] edge : edges) {
            int x = unionFind(id, edge[0]);
            int y = unionFind(id, edge[1]);
            if (x == y) return false;
            id[y] = x;
            n--;
        }
        return n == 1;
    }
    public static int unionFind(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(5, edges));
    }
}