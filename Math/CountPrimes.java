/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = true;
        notPrime[1] = true;
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
}