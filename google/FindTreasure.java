/**
 * 给你一个地图，房间之间有门，有些门需要用锁打开，有一个房间是有宝藏的，有些房间是有钥匙的。给你一个出发点，
 * 问你能不能找到宝藏。先让你设计class
 */
// direct graph
import java.util.*;
public class FindTreasure {
    public boolean canFindTreasure(Room[][] rooms, Room root) {
        Map<Room, List<Room>> graph = new HashMap<>();
        Map<Integer, Key> open = new HashMap<>();
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
            if (!graph.containsKey(cur)) break;
            // the room needs a key to open the door, however we don't have the key
            if (cur.key != null && !open.containsKey(cur.num)) {
                queue.add(cur);
                continue;
            }
            if (cur.haveTreasure) {
                found = true;
                break;
            }
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