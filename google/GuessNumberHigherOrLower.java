/**
 * 
 * Date: 04/12/2018
 * Created By: Shuai Liu
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower, my number is bigger
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
Return 6.
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
   /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */     while (i <= j) {
            int mid = (j - i) / 2 + i;
            int num = guess(mid);
            if (num == 0) return mid;
            if (num == -1) j = mid - 1;
            else i = mid + 1;
        }
        return -1;
    }
}
