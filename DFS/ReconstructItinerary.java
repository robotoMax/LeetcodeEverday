/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary 
 * in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a 
 * single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * 
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
/**
 * First keep going forward until you get stuck. That’s a good main path already. Remaining tickets form cycles which are found 
 * on the way back and get merged into that main path. By writing down the path backwards when retreating from recursion, merging 
 * the cycles into the main path is easy - the end part of the path has already been written, the start part of the path hasn’t 
 * been written yet, so just write down the cycle now and then keep backwards-writing the path.
 * 
 * Example:
 * 
 *    B
 *   /|\ \
 *    |   \
 *    |   _\|
 *    D <---- C
 *   /|\ \  //|\   
 *    |   \/  |
 *    |  / \  |
 *    ||/_ _\||
 *   JFK----->A
 * 
 * From JFK we first visit JFK -> A -> C -> D -> A. There we’re stuck, so we write down A as the end of the route and retreat back 
 * to D. There we see the unused ticket to B and follow it: D -> B -> C -> JFK -> D. Then we’re stuck again, retreat and write down 
 * the airports while doing so: Write down D before the already written A, then JFK before the D, etc. When we’re back from our cycle 
 * at D, the written route is D -> B -> C -> JFK -> D -> A. Then we retreat further along the original path, prepending C, A and 
 * finally JFK to the route, ending up with the route JFK -> A -> C -> D -> B -> C -> JFK -> D -> A.
 */
import java.util.*;
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return res;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) map.put(t[0], new PriorityQueue<>());
            map.get(t[0]).add(t[1]);
        }
        helper(res, map, "JFK");
        return res;
    }
    public void helper(List<String> res, Map<String, PriorityQueue<String>> map, String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            String nextStop = map.get(airport).poll();
            helper(res, map, nextStop);
        }
        res.add(0, airport);
    }
}