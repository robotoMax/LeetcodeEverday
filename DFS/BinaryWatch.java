/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the right.
 * 
 * Given a non-negative integer n which represents the number of LEDs that are currently on, 
 * return all possible times the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * 
 */
import java.util.*;
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        int[] h = {8,4,2,1};
        int[] m = {32,16,8,4,2,1};
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> temp = new ArrayList<>();
            helper(i, h, temp, 0, 0);
            List<Integer>  temp1 = new ArrayList<>();
            helper(num - i, m, temp1, 0, 0);
            for (int a : temp) {
                if (a >= 12) continue;
                for (int b : temp1) {
                    if (b > 59) continue;
                    res.add(a + ":" + ((b >= 10) ? b : "0" + b));
                }
            }
        }
        return res;
    }
    public void helper(int times, int[] nums, List<Integer> temp, int pos, int sum) {
        if (times == 0) {
            temp.add(sum);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            helper(times - 1, nums, temp, i + 1, sum + nums[i]);
        }
        return;
    }
}