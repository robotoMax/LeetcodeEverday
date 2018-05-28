/**
 * 给你一个地图，房间之间有门，有些门需要用锁打开，有一个房间是有宝藏的，有些房间是有钥匙的。给你一个出发点，
 * 问你能不能找到宝藏。先让你设计class
 */
// direct graph
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
import java.util.*;
public class FindTreasure {
    public boolean canFindTreasure(Room[][] rooms, Room root) {
        Map<Room, List<Room>> graph = new HashMap<>();
        Map<Integer, Key> open = new HashMap<>();
        Map<Key, Room> waitingForOpen = new HashMap<>();
        for (Room[] room : rooms) {
            if (!graph.containsKey(room[0])) graph.put(room[0], new ArrayList<>());
            graph.get(room[0]).add(room[1]);
        }
        Queue<Room> queue = new LinkedList<>();
        queue.add(root);
        boolean found = false;
        Set<Key> keys = new HashSet<>();
        while (!queue.isEmpty()) {
            Room cur = queue.poll();
            /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
            if (!graph.containsKey(cur)) break;
            // the room needs a key to open the door, however we don't have the key
            if (cur.key != null && !open.containsKey(cur.num)) {
                waitingForOpen.put(cur.key, cur);
            }
            if (cur.haveTreasure) {
                found = true;
                break;
            }
            /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
            if (cur.key != null) {
                keys.add(key);
                open.put(key.openRoomNumber, key);
            }
            List<Room> children = graph.get(cur);
            for (Room r : children) {
                if (open.containsKey(r.num) || r.key == null) {
                    queue.add(r);
                }
            }
        }
        return found;
    }
}

class Room {
    int num;
    boolean haveTreasure;
    Key key;
    public Room(int num, boolean haveTreasure) {
       this(num, haveTreasure, null);
    }
    public Room(int num, boolean haveTreasure, Key key) {
        this.num = num;
        this.haveTreasure = haveTreasure;
        this.key = key;
    }
}

class Key {
    int openRoomNumber;
    public Key(int openRoomNumber) {
        this.openRoomNumber = openRoomNumber;
    }
}


class NewSolution {
    public boolean getTreasure(int N, List<int[]> doors, Map<int[], String> lockedDoors, Map<Integer, String> keys) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Map<Integer, Set<Integer>> fromToRooom = new HashMap<>();
        Set<String> availableKeys = new HashSet<>();
        Map<String, Integer> lockedRoom = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] room : doors) {
            if (!fromToRooom.containsKey(room[0])) fromToRooom.put(room[0], new HashSet<>());
            if (!fromToRooom.containsKey(room[1])) fromToRooom.put(room[1], new HashSet<>());
            fromToRooom.get(room[0]).add(room[1]);
            fromToRooom.get(room[1]).add(room[0]);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == N - 1) return true;
            visited.add(cur);
            if (keys.containsKey(cur)) {
                availableKeys.add(keys.get(cur));
            }
            for (int next : fromToRooom.getOrDefault(cur, new HashSet<>())) {
                int[] door = new int[] {cur, next};
                if (lockedDoors.containsKey(door)) {
                    String key = lockedDoors.get(door);
                    if (availableKeys.contains(key)) {
                        queue.add(next);
                        availableKeys.remove(key);
                    }
                    else {
                        lockedRoom.put(key, next);
                    }
                }
                else queue.add(next);
            }
        }
        return false;
    }
}