/**
 * 
 * Date: 04/11/2018
 * Created By: Shuai Liu
 * 
 * given a sequence of boxes represented by [w, l, h]. what is the maximum number of boxes that can be put inside into each other.
 * Only the boxes satisfy w < w1 && l < l1 && h < h1, can be placed inside in each other.
 */
// ????? need to prove the correctness
import java.util.*;
public class RussianDollEnvelopes3D {
    public int solution(int[][] dolls) {
        if (dolls == null || dolls.length == 0) return 0;
        int res = 0;
        Arrays.sort(dolls, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) return Integer.compare(b[2], a[2]);
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] dp = new int[dolls.length];
        dp[0] = 1;
        for (int i = 1; i < dolls.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (dolls[j][1] < dolls[i][1] && dolls[j][2] < dolls[i][2]) temp = Math.max(temp ,dp[j]); 
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        RussianDollEnvelopes3D r = new RussianDollEnvelopes3D();
        int[][] dolls = {{3,2,4}, {1,1,1}, {2,2,2}, {5,1,6}, {3,6,1}};
        System.out.println(r.solution(dolls));
    }
}