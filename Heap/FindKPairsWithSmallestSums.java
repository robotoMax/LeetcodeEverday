/**
 * Date: 06/04/2018
 * Created By: Shuai Liu
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]

 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * Return: [1,1],[1,1]
 * 
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 * Return: [1,3],[2,3]

 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 */
// very similar with 378. Kth Smallest Element in a Sorted Matrix
import java.util.*;
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < nums1.length; i++) {
            heap.add(new int[] {i, 0});
        }
        int num = Math.min(k, nums1.length * nums2.length);
        while (res.size() < num) {
            int[] cur = heap.poll();
            res.add(new int[] {nums1[cur[0]], nums2[cur[1]]});
            if (cur[1] == nums2.length - 1) continue;
            heap.add(new int[] {cur[0], cur[1] + 1});
        }
        return res;
    }
}