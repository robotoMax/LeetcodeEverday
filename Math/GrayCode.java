/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
import java.util.*;
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | 1 << i);
            }
        }
        return res;
    }
}
/**
 * I don't know how to come up with the solution i^(i>>1), but I will try to explain why it works.

Adding one to a number results in flipping all the bits from the rightmost zero bit to the end, e.g. 110011 + 1 = 110100

In the general form, i = ...?01...1, i+1 = ...?10...0, ? represents the left bit of the rightmost zero bit, the length of tailing one bits of i is the same as the length of tailing 0 bits of i+1, and the bits from the beginning to the ? are the same.

Then i^(i>>1) = xxx(?^0)10...0, (i+1)^((i+1)>>1) = xxx(?^1)10...0. Since the bits from the beginning to the ? are the same, xxx part of both results must be same, it's obvious the tailing parts of 10...0 must be same, and its length is the same as the length of tailing one bits of i, so there is only one bit difference comes from (?^0) and (?^1).
 */