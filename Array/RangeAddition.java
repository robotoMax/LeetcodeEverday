/**
 * Date: 06/04/2018
 * Created By: Shuai Liu
 * 
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of 
 * subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 * Example:
 * Given:
 *     length = 5,
 *     updates = [
 *         [1,  3,  2],
 *         [2,  4,  3],
 *         [0,  2, -2]
 *     ]
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            res[start] += val;
            if (end < length - 1) res[end + 1] -= val;
        }
        for (int i = 1; i < length; i++) res[i] += res[i - 1];
        return res;
    }
}