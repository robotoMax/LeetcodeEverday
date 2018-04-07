/**
 * 
 * Date: 04/05/2018
 * Created By: Shuai Liu
 * 
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as 
 * ONE single character changed in the gene string.
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make 
 * it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed 
 * to mutate from "start" to "end". If there is no such a mutation, return -1.
 * 
 * Note:
 * 
 * 1. Starting point is assumed to be valid, so it might not be included in the bank.
 * 2. If multiple mutations are needed, all mutations during in the sequence must be valid.
 * 3. You may assume start and end string is not the same.
 * 
 * Example 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * return: 1
 * 
 * Example 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * return: 2
 * 
 * Example 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * return: 3
 */
/**
 * same as word ladder
 */
import java.util.*;
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        set1.add(start);
        if (dict.contains(end)) set2.add(end);
        int res = 0;
        char[] genes = {'A', 'G', 'T', 'C'};
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> temp = new HashSet<>();
            res++;
            for (String str : set1) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char a : genes) {
                        chars[i] = a;
                        String next = new String(chars);
                        if (set2.contains(next)) return res;
                        if (dict.contains(next) && visited.add(next)) {
                            temp.add(next);
                        }
                    }
                    chars[i] = old;
                }
            }
            set1 = temp;
        }
        return -1;
    }
}