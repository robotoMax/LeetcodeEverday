// You are given a vector of integers. You have to delete the odd numbers from it. 
// Expected complexity is O(N) Time and O(1) space

public class DeleteOdd {
    public static void solution(int[] nums) {
        if (nums == null) return;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,55,10,11,15,17};
        solution(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}