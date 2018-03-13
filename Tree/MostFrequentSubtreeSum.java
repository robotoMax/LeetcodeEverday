/**
 * 
 * Date: 03/12/2018
 * Created By: Shuai Liu
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree 
 * rooted at that node (including the node itself). So what is the most frequent subtree sum value? 
 * If there is a tie, return all the values with the highest frequency in any order.
 * 
 * Examples 1
 * Input:
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
import java.util.*;
public class MostFrequentSubtreeSum {
    int max = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        helper(root, map, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public int helper(TreeNode root, Map<Integer, Integer> map, List<Integer> list) {
        if (root == null) return 0;
        int left = helper(root.left, map, list);
        int right = helper(root.right, map, list);
        int temp = left + right + root.val;
        if (!map.containsKey(temp)) {
            map.put(temp, 1);
        }
        else map.put(temp, map.get(temp) + 1);
        int freq = map.get(temp);
        if (freq >= max) {
            if (freq == max) {
                list.add(temp);
            }
            else {
                max = freq;
                list.clear();
                list.add(temp);
            }
        }
        return temp;
    }
}