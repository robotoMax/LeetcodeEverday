/**
    Here is some code from a program:
    public void solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
    }

    given array input is some random array contains n unique elements. For example,
    if n = 3, then the array could be {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2},
    {3, 2, 1}. So what is the expectation of running line min = i, which 64. In this example, 
    {1, 2, 3} --- 1
    {1, 3, 2} --- 1 
    {2, 1, 3} --- 2 
    {2, 3, 1} --- 2
    {3, 1, 2} --- 2
    {3, 2, 1} --- 3
    so the expectation is (1 + 1 + 2 + 2 + 2 + 3) / 6
 */
public class ExpectationOfOneLineCode {
   
}