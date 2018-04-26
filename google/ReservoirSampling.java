/**
 * https://gregable.com/2007/10/reservoir-sampling.html
 * 
 * Date: 04/11/2018
 * Created By: Shuai Liu
 * From: GeeksForGeeks
 * 
 * Reservoir Sampling
 * Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list of n items, where n is 
 * either a very large or unknown number. Typically n is large enough that the list doesn’t fit into main memory. For example, 
 * a list of search queries in Google and Facebook.
 * 
 * So we are given a big array (or stream) of numbers (to simplify), and we need to write an efficient function to randomly 
 * select k numbers where 1 <= k <= n. Let the input array be stream[].
 * 
 * A simple solution is to create an array reservoir[] of maximum size k. One by one randomly select an item from stream[0..n-1]. 
 * If the selected item is not previously selected, then put it in reservoir[]. To check if an item is previously selected or not, 
 * we need to search the item in reservoir[]. The time complexity of this algorithm will be O(k^2). This can be costly if k is big. 
 * Also, this is not efficient if the input is in the form of a stream.
 * 
 * It can be solved in O(n) time. The solution also suits well for input in the form of stream. The idea is similar to this post. 
 * Following are the steps.
 * 1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
 * 2) Now one by one consider all items from (k+1)th item to nth item.
 *     a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
 *     b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
 * 
 * Basic idea:
 * Choose 1, 2, 3, …, k first and put them into the reservoir.
 * For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
 * For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
 * Repeat until k+i reaches n
 * 
 * Proof:
 * For k+i, the probability that it is selected and will replace a number in the reservoir is k/(k+i)
 * For a number in the reservoir before (let’s say X), the probability that it keeps staying in the reservoir is
 * P(X was in the reservoir last time) × P(X is not replaced by k+i)
 * = P(X was in the reservoir last time) × (1 - P(k+i is selected and replaces X))
 * = k/(k+i-1) × （1 - k/(k+i) × 1/k）
 * = k/(k+i)
 * When k+i reaches n, the probability of each number staying in the reservoir is k/n
 * Example:
 * Choose 3 numbers from [111, 222, 333, 444]. Make sure each number is selected with a probability of 3/4
 * First, choose [111, 222, 333] as the initial reservior
 * Then choose 444 with a probability of 3/4
 * For 111, it stays with a probability of
 * P(444 is not selected) + P(444 is selected but it replaces 222 or 333)
 * = 1/4 + 3/4*2/3
 * = 3/4
 * The same case with 222 and 333
 * Now all the numbers have the probability of 3/4 to be picked
 * 
 * 
 * P(k+i is not chosen) = 1- k/(k+i) = i/(k+i) instead of 1/(k+i). Then, your final result in the proof is not k/(k+i) any more.
 * As a matter of fact, the probability of X being kept in reservoir should be
 * P(X was in the reservoir last time) * (P(k+i is not chosen) + P(k+i is chosen but X is not replaced)) = k/(k+i-1) * (i/(k+i) + k/(k+i) * (k-1)/k) = k/(k+i). In another word, the term P(X was in the reservoir) was neglected in your proof. In your example, i happens to be 1, so the result in the example seems to be correct.
 * Another easier way of calculating the probability is P(X was in the reservoir last time) * P(X is not replaced this time) = P(X was in the reservoir last time) * (1- P(X is replaced this time)) = k/(k+i-1) * (1 - k/(k+i) * 1/k) = k/(k+i).
 */
/**
 * leetcode has two problems are relative to this problem. 382 389
 */
import java.util.Random;
public class ReservoirSampling {
    public int[] solution(int[] streams, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = streams[i];
        }
        Random rand = new Random();
        for (int i = k + 1; i < streams.length; i++) {
            int r = rand.nextInt(i + 1);
            if (r < k) {
                res[r] = streams[i];
            }
        }
        return res;
    }
}