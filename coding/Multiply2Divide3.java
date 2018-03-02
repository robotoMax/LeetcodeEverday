import java.util.*;
public class Multiply2Divide3 {
    public List<Integer> solution(int n) {
        List<Integer> res = new ArrayList<>();
        helper(n, res, 1);
        return res;
    }
    public void helper(int n, List<Integer> res, int cur) {
        if (cur == n) {
            return;
        }
        if (cur < n) {
            res.add(2);
            helper(n, res, cur * 2);
        }
        if (cur > n * 3) {
            res.add(3);
            helper(n, res, cur / 3);
        }
        
        return;
    }
    public static void main(String[] args) {
        Multiply2Divide3 m = new Multiply2Divide3();
        List<Integer> res = m.solution(17);
        System.out.println(res.toString());
    }
}