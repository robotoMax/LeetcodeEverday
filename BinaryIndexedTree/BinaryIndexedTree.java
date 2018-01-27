public class BinaryIndexedTree {
    private int[] binaryIndexedTree;
    private int[] nums;
    public BinaryIndexedTree(int[] nums) {
        this.nums = nums;
        this.binaryIndexedTree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            insert(i, nums[i]);
        }
    }
    public void insert(int num, int index) {
        int i = index + 1;
        while (i < nums.length + 1) {
            binaryIndexedTree[i] += num;
            i = getNext(i);
        }
    }

    public int getSum(int i) {
        int res = 0;
        int index = i + 1;
        while (index > 0) {
            res += binaryIndexedTree[index];
            index = getPre(index);
        }
        return res;
    }

    public int getNext(int i) {
        return i + (i & -i);
    }

    public int getPre(int i) {
        return i - (i & -i);
    }
}