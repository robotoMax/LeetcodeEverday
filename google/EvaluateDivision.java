/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating 
 * point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example:
 * Given a / b = 2.0, b / c = 3.0. 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , 
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * 
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
import java.util.*;
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> graphVertice = new HashMap<>();
        Map<String, List<Double>> graphEdge = new HashMap<>();
        for (int i = 0;i < equations.length; i++) {
            String[] equation = equations[i];
            if (!graphVertice.containsKey(equation[0])) graphVertice.put(equation[0], new ArrayList<>());
            if (!graphVertice.containsKey(equation[1])) graphVertice.put(equation[1], new ArrayList<>());
            if (!graphEdge.containsKey(equation[0])) graphEdge.put(equation[0], new ArrayList<>());
            if (!graphEdge.containsKey(equation[1])) graphEdge.put(equation[1], new ArrayList<>());
            graphVertice.get(equation[0]).add(equation[1]);
            graphVertice.get(equation[1]).add(equation[0]);
            graphEdge.get(equation[0]).add(values[i]);
            graphEdge.get(equation[1]).add(1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = helper(graphVertice, graphEdge, query[0], query[1], 1.0, new HashSet<>());
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    public double helper(Map<String, List<String>> v, Map<String, List<Double>> e, String start, String end, double value, Set<String> visited) {
        if (visited.contains(start)) return 0.0;
        if (!v.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        visited.add(start);
        List<String> childVer = v.get(start);
        List<Double> childVal = e.get(start);
        double res = 0.0;
        for (int i = 0; i < childVer.size(); i++) {
            res = helper(v, e, childVer.get(i), end, value * childVal.get(i), visited);
            if (res != 0.0) break;
        }
        visited.remove(start);
        return res;
    }
}