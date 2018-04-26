/**
 * 
 * Date: 04/08/2018
 * Created By: Shuai Liu
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
import java.util.*;
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int pre = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) i++;
            if (pre == nums[i]) res.add("" + pre);
            else {
                res.add(pre + "->" + nums[i]);
            }
        }
        return res;
    }
}