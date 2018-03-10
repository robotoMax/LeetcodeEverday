/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
import java.util.*;
public class TopKFrequentElements {
    // bucket sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (bucket[val] == null) bucket[val] = new ArrayList<>();
            bucket[val].add(key);
        }
        int i = bucket.length - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            if (bucket[i] != null) res.addAll(bucket[i]);
            i--;
        }
        return res;
    }
    // using PriorityQueue
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(heap.poll().getKey());
        }
        return res;
    }    
}