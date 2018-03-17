/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given a time 23:59, you need to get the next closest time using the given number. The number cannot
 * be used repeatedly. The next closest time for 23:59 is 23:59
 */
import java.util.*;
public class NextClosestTimeII {
    int diff = Integer.MAX_VALUE;
    String res = "";
    public String nextClosestTime(String time) {
        List<Integer> list = new ArrayList<>();
        for (char c : time.toCharArray()) {
            if(c != ':') list.add(c - '0');
        }
        int target = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        boolean[] visited = new boolean[4];
        helper(list, target, new StringBuilder(), visited);
        return res;
    }
    public void helper(List<Integer> list, int target, StringBuilder sb, boolean[] visited) {
        if (sb.length() == 4) {
            String temp = sb.toString();
            int hour = Integer.parseInt(temp.substring(0, 2));
            int minute = Integer.parseInt(temp.substring(2, 4));
            if (hour > 23 || minute > 59) return;
            int num = hour * 60 + minute;
            int m = num - target > 0 ? num - target : num + 1440 - target;
            if (m < diff) { 
                diff = m;
                res = temp.substring(0, 2) + ":" + temp.substring(2, 4);
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(list.get(i));
            helper(list, target, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}