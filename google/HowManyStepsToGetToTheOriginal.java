/**
 * 一个数，如果是偶数就除以2， 如果是奇数就乘以3加1. 直到出现循环重复。然后第一问就是给个数然后这个数到循环前要多少步。
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
public class HowManyStepsToGetToTheOriginal {
    public int solution(int num) {
        int res = 0;
        int copy = num;
        while (true) {
            if (copy == num && res != 0) return res;
            if (num % 2 == 0) {
                num /= 2;
                res++;/**
                * Created By: Shuai Liu
                * 请勿作为商业用处。尊重劳动成果
                */
            }
            else {
                num = num * 3 + 1;
                res++;
            }
        }
    }
    public static void main(String[] args) {
        HowManyStepsToGetToTheOriginal h = new HowManyStepsToGetToTheOriginal();
        int num = 8;
        System.out.println(h.solution(num));
    }
}