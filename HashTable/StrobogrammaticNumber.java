/**
 * 
 * Date: 04/08/2018
 * Created By: Shuai Liu
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
import java.util.*;
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char i = num.charAt(left);
            char j = num.charAt(right);
            if (!map.containsKey(i) || !map.containsKey(j)) return false;
            if (map.get(i) != j) return false;
            left++;
            right--;
        }
        return true;
    }
}