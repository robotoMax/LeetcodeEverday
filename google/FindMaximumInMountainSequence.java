/**
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * Example: 
 * Given nums = [1, 2, 4, 8, 6, 3] return 8 
 * Given nums = [10, 9, 8, 7], return 10
 */
public class FindMaximumInMountainSequence {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            }
            else if (nums[mid] < nums[mid + 1]) left = mid + 1;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,8,7,2,1, 0, -1};
        FindMaximumInMountainSequence f = new FindMaximumInMountainSequence();
        System.out.println(f.solution(nums));
    }
}