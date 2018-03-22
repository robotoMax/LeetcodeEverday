/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * 3 1 2 5 4
 * 返回的index为2，即如果(3,1,2)和(5,4)分别排序完成，那么整个数组就排序好了。
 * 2 4 3 1
 * 返回的index为3
 * 注意由于含有所有的1-n的数字，所以数组里是没有重复元素的。
 */
public class SortingPoint {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = (nums.length + 1) * nums.length / 2;
        int left = sum;
        for (int i = 0; i < nums.length; i++) {
            int indexSum = (i + 2) * (i + 1) / 2;
            left -= nums[i];
            if (left + indexSum == sum) return i;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        SortingPoint s = new SortingPoint();
        System.out.println(s.solution(nums));
    }
}
