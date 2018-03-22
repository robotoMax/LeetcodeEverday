/**
 * 给一个数组A，再给一个shuffle A得到的数组B，再给个新数组C，求shuffle C得到的数组D。要求C到D的映射与A到B要一致。 假设所有数组都未排序。
 * For example:
 * A= 2，3，6，7，4；B＝3，2，4，7，6；C= 5，6，1，2，3 那 D就应该是 6，5，3，2，1.
 */
/**
 * LC: Find Anagram Mappings
 * 
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * For example, given
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * Note:
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 */
import java.util.*;
public class ShuffleAToB {
    public int[] solution(int[] A, int[] B, int[] C) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        int[] mapping =  new int[A.length];
        for (int i = 0; i < B.length; i++) {
            mapping[i] = map.get(B[i]);
        }
        int[] res = new int[C.length];
        for (int i = 0; i < C.length; i++) {
            res[mapping[i]] = C[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] A = {2,3,6,7,4};
        int[] B = {3,2,4,7,6};
        int[] C = {5,6,1,2,3};
        ShuffleAToB s = new ShuffleAToB();
        System.out.println(Arrays.toString(s.solution(A, B, C)));
    }
}