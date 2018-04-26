import java.util.*;
public class RabbitCommonAncester {
    // baby id, <p1 id, p2 id>;
    public int solution(Map<Integer, List<Integer>> map, Integer a, Integer b) {
        Set<Integer> ancester = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        queue.add(b);
        while (!queue.isEmpty()) {
            int baby = queue.poll();
            for (int parent : map.getOrDefault(baby, new ArrayList<>())) {
                if (ancester.contains(parent)) return parent;
                queue.add(parent);
                ancester.add(parent);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.get(1).add(2);
        map.get(1).add(3);
        map.put(4, new ArrayList<>());
        map.get(4).add(1);
        map.get(4).add(3);
        map.put(5, new ArrayList<>());
        map.get(5).add(2);
        map.get(5).add(4);
        map.put(6, new ArrayList<>());
        map.get(6).add(4);
        map.get(6).add(5);
        RabbitCommonAncester r = new RabbitCommonAncester();
        System.out.println(r.solution(map, 1, 6));
    }
}