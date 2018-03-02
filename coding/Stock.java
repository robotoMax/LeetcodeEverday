import java.util.*;
public class Stock {
    // case 1: k = 1 time
    // return when buy and sell stock

    public int[] stock1(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[2];
        int minP = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minP) {
                minP = nums[i];
                res[0] = i;
            }
            if (nums[i] - minP > max) {
                max = nums[i] - minP;
                res[1] = i;
            }
        }
        return res;
    }

    // case 2: k = infinite 
    // return the max profit
    public int stock2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int t_ik0 = 0;
        int t_ik1 = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            t_ik0 = Math.max(t_ik0, t_ik1 + nums[i]);
            t_ik1 = Math.max(t_ik1, t_ik0 - nums[i]);
        }
        return t_ik0;
    }

    // case 3: k = 2
    // return max profit
    public int stock3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int t_2k0 = 0;
        int t_2k1 = Integer.MIN_VALUE;
        int t_1k0 = 0;
        int t_1k1 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            t_2k0 = Math.max(t_2k0, t_2k1 + nums[i]);
            t_2k1 = Math.max(t_2k1, t_1k0 - nums[i]);
            t_1k0 = Math.max(t_1k0, t_1k1 + nums[i]);
            t_1k1 = Math.max(t_1k1, -nums[i]);
        }
        return t_2k0;
    }

    // case 4: k
    // return max profit
    public int stock4(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (k >= nums.length / 2) {
            return stock2(nums);
        }
        int[] t_ik0 = new int[k + 1];
        int[] t_ik1 = new int[k + 1];
        Arrays.fill(t_ik1, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            for (int j = k; j >= 1; j--) {
                t_ik0[j] = Math.max(t_ik0[j], t_ik1[j] + nums[i]);
                t_ik1[j] = Math.max(t_ik1[j], t_ik0[j - 1] - nums[i]);
            }
        }
        return t_ik0[k];
    }

    public static void main(String[] args) {
        Stock s = new Stock();
        int[] nums = {2,14,81,31,19,1,45,12,45,875,21,43,65,53,1,35,43,43};
        int[] res = s.stock1(nums);
        for (int num : res) System.out.println(num);
        System.out.println("Inifite times transactions: " + s.stock2(nums));
        System.out.println("at most 2 times trasactions: " + s.stock3(nums));
        int k = 4;
        System.out.printf("%d times transactions: ", k);
        System.out.println(s.stock4(nums, k));
    }
}