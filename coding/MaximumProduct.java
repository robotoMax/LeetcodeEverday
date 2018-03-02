public class MaximumProduct {
    public int solution(int[] nums) {
        Arrays.sort(array);

        int n = array.length;
        int maxProduct;

        //case> pick the last 3 numbers(when the array has only negative, or only positive numbers)
        maxProduct = array[n - 1] * array[n - 2] * array[n - 3];

        //case> pick 2 numbers from the left end and 1 number from the right end
        maxProduct = Math.max(maxProduct, array[0] * array[1] * array[n - 1]);

        return maxProduct;
    }
}