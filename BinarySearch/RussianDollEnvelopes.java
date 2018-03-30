/**
 * 
 * Date: 03/29/2018
 * Created By: Shuai Liu
 * 
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit 
 * into another if and only if both the width and height of one envelope is greater than the width and height of 
 * the other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 
 * ([2,3] => [5,4] => [6,7]).
 */
/**
 * First, we need to sort the envelopes by the width by ascending order, if the widths are same, sort height by descending order.
 * Second, find the longest increaseing subsequence based on height.
 * 
 * Since the width is increasing, we only need to consider height.
 * [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an 
 * increasing number if the order is [3, 3], [3, 4]
 */
import java.util.*;
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        int res = 1;
        int[] tail = new int[envelopes.length];
        tail[0] = envelopes[0][1];
        for (int[] e : envelopes) {
            if (e[1] < tail[0]) {
                tail[0] = e[1];
            }
            else if (e[1] > tail[res - 1]) {
                tail[res] = e[1];
                res++;
            }
            else {
                int index = binarySearch(tail, 0, res - 1, e[1]);
                tail[index] = e[1];
            }
        }
        return res;
    }
    public int binarySearch(int[] nums, int start, int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= key) {
                end = mid;
            }
            else start = mid + 1;
        }
        return end;
    }
}