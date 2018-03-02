import java.util.*;
public class LookingForPrimeNumber {
    public List<Integer> solution(int n) {
        boolean[] prime = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) list.add(i);
        }
        return list;
    }
    public List<Integer> factorialPrmime(int n) {
        
    }
    public static void main(String[] args) {
        LookingForPrimeNumber l = new LookingForPrimeNumber();
        List res = l.solution(10);
        System.out.println(res.toString());
    }
}