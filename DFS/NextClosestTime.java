/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. 
 * "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * 
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 * 
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed 
 * that the returned time is next day's time since it is smaller than the input time numerically.
 */
import java.util.*;
public class NextClosestTime {
    int diff = Integer.MAX_VALUE;
    String res = "";
    public String nextClosestTime(String time) {
        List<Integer> list = new ArrayList<>();
        for (char c : time.toCharArray()) {
            if (c != ':') list.add(c - '0');
        }
        int target = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        helper(target, list, "");
        return res;
    }
    public void helper(int target, List<Integer> list, String temp) {
        if (temp.length() == 4) {
            int hour = Integer.parseInt(temp.substring(0, 2));
            int minutes = Integer.parseInt(temp.substring(2));
            if (hour > 23 || minutes > 59) return;
            int num = hour * 60 + minutes;
            int m = num - target > 0 ? num - target : num + 1440 - target;
            if (m < diff) {
                diff = m;
                res = temp.substring(0, 2) + ":" + temp.substring(2);
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            helper(target, list, temp + list.get(i));
        }
    }
}