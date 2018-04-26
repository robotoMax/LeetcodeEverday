import java.util.*;
public class CycleOfAnArray {
    public int solution(int[] nums) {
        int[] table = KMP(nums);
        System.out.println(Arrays.toString(table));
        return 0;
    }
    public int[] KMP(int[] temp) {
        int[] res = new int[temp.length];
        int i = 1;
        int index = 0;
        while (i < temp.length) {
            if (temp[i] == temp[index]) {
                res[i] = index + 1;
                i++;
                index++;
            }
            else {
                if (index != 0) {
                    index = res[index - 1];
                }
                else i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        CycleOfAnArray c = new CycleOfAnArray();
        int[] nums = {1,2,1};
        System.out.println(c.solution(nums));
    }
}