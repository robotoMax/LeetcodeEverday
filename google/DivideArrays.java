/**
 * given a string[] = a, b, c, d ......
 * return [a], [b,c], [d,e,f,g].... power of two as a group
 */
import java.util.*;
public class DivideArrays {
    public List<List<String>> solution(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int i = 0;
        int p = 0;
        while (((int) Math.pow(2, i + 1) - 1) <= strs.length) {
            if (res.size() == i) {
                res.add(new ArrayList<>());
            }
            System.out.println(i);
            while (res.get(i).size() < ((int) Math.pow(2, i))) {
                res.get(i).add(strs[p++]);
            }
            i++;
        }
        if (p < strs.length) {
            res.add(new ArrayList<>());
            while (p < strs.length) {
                res.get(res.size() - 1).add(strs[p++]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        DivideArrays d = new DivideArrays();
        String[] strs = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
        for (List<String> l : d.solution(strs)) {
            System.out.println(l.toString());
        }
    }
}