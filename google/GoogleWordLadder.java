/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
import java.util.*;
public class GoogleWordLadder {
    public boolean solution(List<String> dict, String start, String end) {

        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(end)) return true;
            for (String str : dict) {
                if (canTurn(cur, str) && visited.add(str)) {
                    queue.add(str);
                }
                /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
            }
        }
        return false;
    }
    /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
    public boolean canTurn(String cur, String str) {
        int len1 = cur.length();
        int len2 = str.length();
        if (Math.abs(len1 - len2) > 1) return false;
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (cur.charAt(i) != str.charAt(i)) {
                if (len1 == len2) return cur.substring(i + 1).equals(str.substring(i + 1));
                if (len1 > len2) return cur.substring(i + 1).equals(str.substring(i));
                else return cur.substring(i).equals(str.substring(i + 1));
            }
        }
        return false;
    }
    public static void main(String[] args) {
        GoogleWordLadder g = new GoogleWordLadder();
        List<String> dict = new ArrayList<>();
        dict.addAll(Arrays.asList(new String[] {"abc", "aec", "ac"}));
        String start = "abc";
        String end = "ac";
        System.out.println(g.solution(dict, start, end));
    }
}