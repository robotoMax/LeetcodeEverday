// You are given an array of values, (not necessary integers or positives) and a value. 
// You have to print all the pairs whose sum is given value. 
// Write a general method which can accept integers, float, doubles, long, or any other thing where this make sense.
import java.util.*;
public class GeneralTwoSum {

    public static List<List<Integer>> solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res.add(Arrays.asList(map.get(target - nums[i]), i));
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,-1,1,2,7,8,3,4,9,10,0};
        int target = 8;
        List<List<Integer>> list = solution(nums, target);
        for (List<Integer> a : list) {
            System.out.println(a.toString());
        }
    }

}