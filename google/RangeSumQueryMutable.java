/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5] 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    
    int[] nums;
    int[] binaryIndexedTree;
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.binaryIndexedTree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            insert(i, nums[i]);
        }
    }

    public void insert(int i, int val) {
        int index = i + 1;
        while (index < binaryIndexedTree.length) {
            binaryIndexedTree[index] += val;
            index = getNext(index);
        }
    }

    public int getNext(int i) {
        return i + (i & -i);
    }

    public int getPre(int i) {
        return i - (i & -i);
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        insert(i, diff);
    }

    public int getSum(int i) {
        int index = i + 1;
        int res = 0;
        while (index > 0) {
            res += binaryIndexedTree[index];
            index = getPre(index);
        }
        return res;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}