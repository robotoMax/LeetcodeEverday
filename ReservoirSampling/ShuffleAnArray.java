import java.util.Random;

/**
 * Date: 06/01/2018
 * Created By: Shuai Liu
 * 
 * Shuffle a set of numbers without duplicates.
 * 
 * Example:
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleAnArray {
    
    int[] nums;
    Random rand;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            int j = rand.nextInt(i + 1);
            swap(copy, i, j);
        }
        return copy;
    }
    public void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}