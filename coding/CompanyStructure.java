// A company's organizational structure is represented as 
// 1: 2, 3, 4 
// In the above employees with id 2, 3 and 4 report to 1 
// Assume the following hierarchy. 
// 1: 2, 3, 4 
// 3: 5, 6, 7 
// 5: 8, 9, 10 
// Given an employee Id, return all the employees reporting to him directly or indirectly

import java.util.*;
public class CompanyStructure {
    public static List<Integer> solution(int id) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>(Arrays.asList(2,3,4)));
        map.put(3, new ArrayList<>(Arrays.asList(5,6,7)));
        map.put(5, new ArrayList<>(Arrays.asList(8,9,10)));
        map.put(9, Arrays.asList(11,12,13));
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(id)) return res;
        helper(map, id, res);
        return res;
    }
    public static void helper(Map<Integer, List<Integer>> map, int id, List<Integer> res) {
        if (!map.containsKey(id)) return;
        List<Integer> list = map.get(id);
        res.addAll(list);
        for (int i : list) {
            helper(map, i, res);
        }
        return;
    }
    public static void main(String[] args) {
        System.out.println(solution(3).toString());
    }
}