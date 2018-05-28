/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
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
    } //* 请勿作为商业用处。尊重劳动成果
    public static void main(String[] args) {
        CycleOfAnArray c = new CycleOfAnArray();
        int[] nums = {1,2,1};
        System.out.println(c.solution(nums));
    }
}