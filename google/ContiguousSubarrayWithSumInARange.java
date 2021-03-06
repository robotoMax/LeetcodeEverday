/**
 * It can work if and only if the input are all positive.
 */
import java.util.*;
public class ContiguousSubarrayWithSumInARange {
    public int subArrayWithSumInRange(int[] A, int a, int b){
        int count = 0;
        TreeSet<int[]> treeSet = new TreeSet<>((a1, b1) -> {
            if (a1[0] == b1[0]) return Integer.compare(a1[1], b1[1]);
            return Integer.compare(a1[0], b1[0]);
        });
        int cumsum = 0;
        
        for(int i = 0; i< A.length; i++){
            cumsum+=A[i];
            
            if(A[i] >= a && A[i] <= b){
                count++;
            }
            else if(cumsum >= a && cumsum <= b){
                count++;
            }
    
            NavigableSet<int[]> subSet = treeSet.subSet(new int[]{cumsum-b, i+1}, true, new int[]{cumsum-a, i+1}, false);
            if(!subSet.isEmpty()){
                count += Math.abs(subSet.first()[1] - subSet.last()[1])+1;
            }
            treeSet.add(new int[]{cumsum, i});
        }
        
        return count;
    }
    public static void main(String[] args) {
        ContiguousSubarrayWithSumInARange c = new ContiguousSubarrayWithSumInARange();
        int[] nums = {7,-11,4,7, 7};
        System.out.println(c.subArrayWithSumInRange(nums, 7, 10));
    }
}