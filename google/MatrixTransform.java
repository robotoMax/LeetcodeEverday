/**
 * 
 * Date: 04/10/2018
 * Created By: Shuai Liu
 * 
 * a:1, b:2
 * b:2, c:3
 * 然后转换成
 * a, b, c
 * 1, 2, .
 * ., 2, 3
 */
import java.util.*;
public class MatrixTransform {
    public List<List<Object>> solution(List<List<Map<Character, Integer>>> matrix) {
        List<List<Object>> res = new ArrayList<>();
        for (int i = 0; i < matrix.size() + 1; i++) {
            res.add(new ArrayList<>());
        }
        TreeSet<Character> keys = new TreeSet<>();
        for (List<Map<Character, Integer>> l : matrix) {
            for (int i = 0; i < l.size(); i++) {
                for (char c : l.get(i).keySet()) {
                    keys.add(c);
                }
            }
        }
        res.get(0).addAll(keys);
        for (int i = 1; i < res.size(); i++) {
            List<Object> list = res.get(0);
            List<Map<Character, Integer>> row = matrix.get(i - 1);
            List<Object> temp = res.get(i);
            for ()
        }
    }
}