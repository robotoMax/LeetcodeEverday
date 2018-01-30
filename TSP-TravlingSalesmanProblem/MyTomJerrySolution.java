/*
* Author: Shuai Liu
* Date: 01/30/2018 11:06
*
* Tom and Jerry Problem: There is a maze. A cell have a cheese is 2, empty is 0, has obstacle is 1. 
* Tom is at (0, 0), Jerry is at (x, y) which is a input. Tom need to collect all the cheeses then give to Jerry.
* What is the minimal steps to collect all the cheese and meeting Jerry at point (x, y). If it cannot happen, return -1;
*
*
* This problem is related to TSP (Travling Salesman Problem), the following description is about TSP. Line 43-64 is the way to solve TSP.
*
* Problem Descripton: 
* given a direct or nondirect graph with weight on every edge. 
* Starting from an vertex and traverse all other vertex exactly once and go back to the starting vertex.
* what is the optimal solution?
* Using DP Held-Karp Algorithm
* 
* notice: it's an np hard problem
* the brute force way to do this is to traverse all the vertex and get the permutation of the vertices to see what's the minimal weight. 
* But the time complexity is O(N!) 
*/

import java.util.*;
public class MyTomJerrySolution {
    public static int[][] dirc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static boolean canReach = true;
    public static int solution(int[][] maze, int x, int y) {
        List<List<Integer>> cheeseLocation = new ArrayList<>();
        List<Integer> oringinal = arrayToList(new int[] {0 , 0});
        cheeseLocation.add(oringinal);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    List<Integer> loc = arrayToList(new int[] {i, j});
                    cheeseLocation.add(loc);
                }
            }
        }
        int[][] cheeseDist = getCheeseDist(maze, cheeseLocation);
        if (!canReach) {
            return -1;
        }
        Map<Index, Integer> minCostDP = new HashMap<>();
        List<Set<Integer>> allSets = generationSubSets(cheeseDist.length - 1);
        for (Set<Integer> set : allSets) {
            for (int curVer = 1; curVer < cheeseDist.length; curVer++) {
                if (set.contains(curVer)) continue;
                Index index = new Index(curVer, set);
                int minCost = Integer.MAX_VALUE;
                int minPrev = 0;
                Set<Integer> copySet = new HashSet<>(set);
                for (int preVertex : set) {
                    int cost = cheeseDist[preVertex][curVer] + getCost(copySet, preVertex, minCostDP);
                    if (cost < minCost) {
                        minCost = cost;
                        minPrev = preVertex;
                    }
                }
                if (set.size() == 0) {
                    minCost = cheeseDist[0][curVer];
                }
                minCostDP.put(index, minCost);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Index, Integer> entry : minCostDP.entrySet()) {
            Index temp = entry.getKey();
            if (temp.subSetVertex.size() != cheeseDist.length - 2) continue;
            else {
                int dist = entry.getValue();
                int[] cur = listToArray(cheeseLocation.get(temp.curVertex));
                int what = getMinDist(cur[0], cur[1], x, y, maze);
                if (what == -1) {
                    continue;
                }
                else  min = Math.min(min, what + dist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int getMinDist(int i, int j, int x, int y, int[][] maze) {
        int res = 0;
        List<Integer> init = arrayToList(new int[] {i, j});
        List<Integer> destination = arrayToList(new int[] {x, y});
        Queue<List<Integer>> queue = new LinkedList<>();
        Map<List<Integer>, Integer> distance = new HashMap<>();
        distance.put(init, 0);
        queue.add(init);
        while (!queue.isEmpty()) {
            List<Integer> state = queue.poll();
            int d = distance.get(state);
            if (state.equals(destination)) {
                res = d;
                return res;
            }
            int[] curLoc = listToArray(state);
            for (int[] dir : dirc) {
                int r = curLoc[0] + dir[0];
                int c = curLoc[1] + dir[1];
                if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) {
                    int[] tmp = new int[] {r, c};
                    List<Integer> tmpList = arrayToList(tmp);
                    if (!distance.containsKey(tmpList)) {
                        distance.put(tmpList, d + 1);
                        queue.add(tmpList);
                    } 
                }
            }
        }
        return -1;
    }

    public static int getCost(Set<Integer> set, int pre, Map<Index, Integer> minDP) {
        set.remove(pre);
        Index index = new Index(pre, set);
        int cost = minDP.get(index);
        set.add(pre);
        return cost;
    }

    public static int[][] getCheeseDist(int[][] maze, List<List<Integer>> loc) {
        int[][] res = new int[loc.size()][loc.size()];
        for (int i = 0; i < loc.size(); i++) {
            for (int j = i + 1; j < loc.size(); j++) {
                List<Integer> cur = loc.get(i);
                List<Integer> next = loc.get(j);
                Queue<List<Integer>> queue = new LinkedList<>();
                Map<List<Integer>, Integer> dist = new HashMap<>();
                dist.put(cur, 0);
                queue.add(cur);
                boolean reach = false;
                while (!queue.isEmpty()) {
                    List<Integer> state = queue.poll();
                    int d = dist.get(state);
                    if (state.equals(next)) {
                        res[i][j] = d;
                        res[j][i] = d;
                        reach = true;
                        break;
                    }
                    else {
                        int[] curArr = listToArray(state);
                        for (int[] dir : dirc) {
                            int r = curArr[0] + dir[0];
                            int c = curArr[1] + dir[1];
                            if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) {
                                int[] tmp = new int[] {r, c};
                                List<Integer> tmpList = arrayToList(tmp);
                                if (!dist.containsKey(tmpList)) {
                                    dist.put(tmpList, d + 1);
                                    queue.add(tmpList);
                                }
                            }
                        }
                    }
                   
                }
                if (queue.size() == 0 && !reach) {
                    canReach = false;
                }
            }
        }
        return res;
    }
    public static List<Integer> arrayToList(int[] ar) {
        List<Integer> res = new ArrayList<>();
        res.add(ar[0]);
        res.add(ar[1]);
        return res;
    }

    public static int[] listToArray(List<Integer> list) {
        int[] res = new int[2];
        res[0] = list.get(0);
        res[1] = list.get(1);
        return res;
    }

    public static List<Set<Integer>> generationSubSets(int n) {
        List<Set<Integer>> res = new ArrayList<>();
        helper(n, res, 1, new ArrayList<>());
        Collections.sort(res, (a, b) -> a.size() - b.size());
        res.remove(res.size() - 1);
        return res;
    } 

    public static void helper(int n, List<Set<Integer>> res, int pos, List<Integer> temp) {
        res.add(new HashSet(createSet(temp)));
        for (int i = pos; i <= n; i++) {
            temp.add(i);
            helper(n, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
        return;
    }
    public static Set<Integer> createSet(List<Integer> temp) {
        Set<Integer> res = new HashSet<>();
        for (int i : temp) res.add(i);
        return res;
    }
    public static void main(String[] args) {
        int[][] maze = {{0,0,0,1,2},
        			    {0,1,0,1,1},
        	    	    {1,2,0,0,0},
        		        {2,0,0,0,1},
                        {0,0,0,0,0}};
        int[][] sm = {{0,2,0},
                        {1,1,2},
                        {1,0,0}};	
        //System.out.println(solution(maze, 4, 2));
        System.out.println(solution(sm, 2, 1));
    }

}

class Index {
    int curVertex;
    Set<Integer> subSetVertex;
    public Index(int curVertex, Set<Integer> subSetVertex) {
        this.curVertex = curVertex;
        this.subSetVertex = subSetVertex;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        if (curVertex != index.curVertex) return false;
        return !(this.subSetVertex != null ? !this.subSetVertex.equals(index.subSetVertex) : index.subSetVertex != null);
    }
    @Override
    public int hashCode() {
        int res = curVertex;
        res = 31 * res + (this.subSetVertex != null ? this.subSetVertex.hashCode() : 0);
        return res;
    }
}