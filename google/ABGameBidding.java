import java.util.Arrays;

/**
 * 
 * Date: 04/10/2018
 * Created By: Shuai Liu
 * 
 * A和B,最多进行2n - 1场比赛，当某个球队有限赢得n场比赛的时候，比赛结束，有一个玩家，特别喜欢A球队，他有m元钱，总是买A球队赢，
 * 如果买了x元钱A赢，A赢得到2x元，A输得到0元，返回一个矩阵，使得最终如果A先赢n场，那么始终剩余2m元，B赢了使用剩余0元
 */
/**
 * 
 * We have two functions: f[i][j] -- remaining money when the score is i : j
 *                        g[i][j] -- bidding the next game when the score is i : j
 * And the i indicate A's winning time, j is B's.
 * So f[3][0] == f[3][1] == f[3][2] = 2m, f[0][3] == f[1][3] == f[1][3] = 0
 *    g[3][0] == g[3][1] == g[3][2] = 0, g[0][3] == g[1][3] == g[1][3] = 0
 * f[i + 1][j] = f[i][j] - g[i][j] + 2 * g[i][j] = f[i][j] + g[i][j]
 * f[i][j + 1] = f[i][j] - g[i][j]
 * 
 * So we get f[i][j] = (f[i + 1][j] + f[i][j + 1]) / 2.0;
 *           g[i][j] = (f[i + 1][j] - f[i][j + 1]) / 2.0;
 * And we can fill these two char from (n, n) to (0, 0), if f[0][0] == m, then we can find a way to bid when A wins n games, we 
 * remain 2m money, otherwise we remain nothing. And g[i][j] is our bidding stradegy
 * 
 * For f: 
 *     0      1      2        3
 * 0   m      5m/8   m/4      0
 * 1  11m/8     m    m/2      0
 * 2  7m/4    1.5m    m       0
 * 3   2m      2m      2m    2m
 * 
 * For g:
 *     0     1      2       3
 * 0   0    3m/8   m/4      0
 * 1  3m/8  m/4    m/2      0
 * 2  m/4   m/2     m       0
 * 3   0     0      0       0
 */
public class ABGameBidding {
    public double[][] solution(int n, int m) {
        double[][] f = new double[n + 1][n + 1];
        double[][] g = new double[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) f[n][i] = 2 * m;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                f[i][j] = getNum(f[i + 1][j], f[i][j + 1], true);
                g[i][j] = getNum(f[i + 1][j], f[i][j + 1], false);
            }
        }
        return g;
    }
    public double getNum(double a, double b, boolean plus) {
        if (plus) return (a + b) / 2.0;
        else return (a - b) / 2.0;
    }
    public static void main(String[] args) {
        ABGameBidding abGameBidding = new ABGameBidding();
        double[][] res = abGameBidding.solution(3, 10);
        for (int i = 0; i < res.length; i++)
            System.out.println(Arrays.toString(res[i]));
    }
}