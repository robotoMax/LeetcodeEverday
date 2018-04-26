/**
 * 
 * Date: 04/16/2018
 * Created By: Shuai Liu
 * 
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], 
 * where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
 * Return the smallest possible value of D.
 * Example:
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 * Output: 0.500000
 * Note:
 * 1. stations.length will be an integer in range [10, 2000].
 * 2. stations[i] will be an integer in range [0, 10^8].
 * 3. K will be an integer in range [1, 10^6].
 * 4. Answers within 10^-6 of the true value will be accepted as correct.
 */
public class MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length == 0) return 0;
        double left = 0;
        double right = stations[stations.length - 1] - stations[0];
        while (left + 1e-6 < right) {
            int count = 0;
            double mid = (right - left) / 2 + left;
            for (int i = 1; i < stations.length; i++) {
                count += (int) Math.ceil((stations[i] - stations[i - 1]) / mid) - 1;
            }
            if (count > K) left = mid;
            else right = mid;
        }
        return left;
    }
}