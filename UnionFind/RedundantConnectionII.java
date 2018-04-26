 /**
 * 
 * Date: 04/06/2018
 * Created By: Shuai Liu
 * 
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for 
 * which all other nodes are descendants of this node, plus every node has exactly one parent, except for
 * the root node which has no parents.
 * 
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 
 * 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen 
 * from 1 to N, and was not an edge that already existed.
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents 
 * a directed edge connecting nodes u and v, where u is a parent of child v.
 * 
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are 
 * multiple answers, return the answer that occurs last in the given 2D-array.
 * 
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 *   1
 *  / \
 * v   v
 * 2-->3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * Note:
 * 1. The size of the input 2D-array will be between 3 and 1000.
 * 2. Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
/**
 * 1. each node only has one parent, just with a loop. --- just using normal union find
 *          like this:
 *         5 <- 1 -> 2
 *              ^    |
 *              |    v
 *              4 <- 3
 * 
 * 2. a node has two parent.
 *    2.1 with loop
 *        4
 *        |
 *        v
 *        1
 *       / ^
 *      v   \
 *      2-->3
 *   
 * 
 *    2.2 with no loop: delete the second edge that creates second parent.
 *    like this:
 *        1
 *       / \
 *      v   v
 *      2-->3
 * 
 * 1) Check whether there is a node having two parents. 
 *     If so, store them as candidates A and B, and set the second edge invalid. 
 * 2) Perform normal union find. 
 *     If the tree is now valid 
 *            simply return candidate B  ----> situation 2.2
 *     else if candidates not existing 
 *            we find a circle, return current edge; ----> situation 1
 *     else 
 *            remove candidate A instead of B.  -----> delete the one that creates circle. 2.1 
 */
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        // Because this is a directed graph, we can do the following step to find if a node has two parents.
        for (int[] e : edges) {
            if (roots[e[1]] == 0) roots[e[1]] = e[0];
            else {
                can1 = new int[] {roots[e[1]], e[1]};
                can2 = new int[] {e[0], e[1]};
                e[1] = 0;
            }
        }
        // union find
        for (int i = 0; i < roots.length; i++) roots[i] = i;
        for (int[] e : edges) {
            int a = find(e[0], roots);
            int b = find(e[1], roots);
            if (a == b) {
                if (can1[0] == -1) return e; // ----> just has a loop
                return can1; // even though we disabled the second edge, there is still a loop. Then, it's situation that have a loop and two parents.
            }
            roots[b] = a;
        }
        return can2; // -----> with no loop, just two parents
    }
    public int find(int key, int[] roots) {
        int par = roots[key];
        while (par != roots[par]) {
            par = roots[par];
        }
        return par;
    }
}