public class CombinationSum4 {
    // this may cause time limited error, but using dp can solve this. 
    // Since, the combination sum of this problem doesn't need to be unique,
    // combo[4] = combo[3] + combo[2] + combo[1];
    // *************************************************************************
    // int res = 0;
    // public int solution(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) return 0;
    //     helper(nums, target, 0, 0);
    //     return res;
    // }
    // public void helper(int[] nums, int target, int cur, int pos) {
    //     if (cur > target) return;
    //     if (cur == target) {
    //         res++;
    //         return;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         helper(nums, target, cur + nums[i], i);
    //     }
    //     return;
    // }
    // *************************************************************************
    public int solution(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += solution(nums, target - nums[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        CombinationSum4 c = new CombinationSum4();
        int[] nums = {1,2,3};
        int target = 32;
        System.out.println(c.solution(nums, target));
    }
}