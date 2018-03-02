import java.util.Arrays;

// given two input array:
// numsA: {a,b,c,d,e} numsB: {3,0,2,4,1}
// you need output the new array A that reordered as the array B.
// for instance, the first position shoule be numsA[3] = d, the second should be numsA[0] = b
// you need do it in-place

// every time, we put the first element in B to the correct position. 
// first we swap 3 and 4, then 3 is at the correct position.
public class ReorderArray {
    public void solution(char[] A, char[] B) {
        if (A == null || A.length == 0) return;
        int i = 0;
        while (i < A.length) {
            if (i == B[i]) {
                i++;
            }
            else {
                swap(A, B[i], B[B[i]]);
                swap(B, i, B[i]);
            }
        }
        return;
    }
    public void swap(char[] A, int i, int j) {
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return;
    }
    public static void main(String[] args) {
        ReorderArray r = new ReorderArray();
        char[] A = {'a','b','c','d','e'};
        char[] B = {3,4,0,2,1};
        r.solution(A, B);
        System.out.println(Arrays.toString(A));
    }
}