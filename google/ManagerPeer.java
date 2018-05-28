/**
 * 
 * Date: 03/28/2018
 * Created By: Shuai Liu
 * 
 * 设计一个公司员工管理系统，实现三个函数，在input stream里不断被调用（sequence is not guaranteed）
 * 1. void manages(String m1, String e1) { // 代表m1是e1的direct manager，每个人都只能最多一个manager}
 * 2. void peer(String e1, String e2) {// 代表e1和e2是同级关系}
 * 3. boolean isManaging(String e1, String e2) {// 如果e1，e2有direct或者indirect的管理关系，返回true，otherwise false}
*//**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
import java.util.*;
public class ManagerPeer {

    Map<String, Set<String>> managerGraph;
    Map<String, Set<String>> peerGraph;

    public ManagerPeer() {
        managerGraph = new HashMap<>();
        peerGraph = new HashMap<>();
    }

    public void manage(String m, String e) {
        if (!managerGraph.containsKey(m)) {
            managerGraph.put(m, new HashSet<>());
        }
        managerGraph.get(m).add(e);
    }

    public void peer(String e1, String e2) {
        if (!peerGraph.containsKey(e1)) {
            peerGraph.put(e1, new HashSet<>());
        }
        if (!peerGraph.containsKey(e2)) {
            peerGraph.put(e2, new HashSet<>());
        }
        peerGraph.get(e1).add(e2);
        peerGraph.get(e2).add(e1);
    }

    // public boolean isManaging(String e1, String e2) {
    //     Set<String> start = new HashSet<>();
    //     Set<String> end = new HashSet<>();
    //     Set<String> visited = new HashSet<>();
    //     if (!managerGraph.containsKey(e1) && !managerGraph.containsKey(e2) && !peerGraph.containsKey(e1) && !peerGraph.containsKey(e2)) return false;
    //     if (peerGraph.containsKey(e1) && peerGraph.get(e1).contains(e2)) return false;
    //     start.add(e2);
    //     end.add(e1);
    //     while (!start.isEmpty() && !end.isEmpty()) {
    //         if (start.size() > end.size()) {
    //             Set<String> temp = start;
    //             start = end;
    //             end = temp;
    //         }
    //         Set<String> next = new HashSet<>();
    //         for (String str : start) {
    //             if (end.contains(str)) return true;
    //             if (!visited.add(str)) continue;
    //             Set<String> peers = null;
    //             Set<String> sub = null;
    //             if (peerGraph.get(str) != null) peers = peerGraph.get(str);
    //             if (managerGraph.get(str) != null) sub = managerGraph.get(str);
    //             if (peers != null) {
    //                 next.addAll(peers);
    //             }
    //             if (sub != null) next.addAll(sub);
    //         }
    //         start = next;
    //     }
    //     return false;
    // }

    public boolean isManaging(String e1, String e2) {
        Set<String> visited = new HashSet<>();
        if (peerGraph.containsKey(e1) && peerGraph.get(e1).contains(e2)) return false;
        if (helper(e1, e2, visited) || helper(e2, e1, visited)) return true;
        return false;
    }

    public boolean helper(String m, String e, Set<String> visited) {
        if (m.equals(e)) return true;
        if (visited.contains(m)) return false;
        visited.add(m);
        Set<String> peers = null;
        if (peerGraph.containsKey(m)) {
            peers = peerGraph.get(m);
        }
        if (peers != null) {
            for (String peer : peers) {
                if (helper(peer, e, visited)) return true;
            }
        }
        Set<String> employee = managerGraph.get(m);
        if (employee != null) {
            for (String emp : employee) {
                if (helper(emp, e, visited)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ManagerPeer managerPeer = new ManagerPeer();
        managerPeer.manage("a", "b");
        managerPeer.manage("b", "c");
        managerPeer.manage("c", "d");
        managerPeer.manage("d", "f");
        managerPeer.manage("g", "z");
        managerPeer.peer("e", "c");
        managerPeer.peer("a", "g");
        System.out.println(managerPeer.isManaging("a", "f"));
    }
}