/**
 * 
 * Date: 04/07/2018
 * Created By: Shuai Liu
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, 
 * and the rest of the elements are emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that 
 * is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people 
 * could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the 
 * same name.
 * 
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, 
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Example 1:
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", 
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", 
 * "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * 
 * Note:
 * 1. The length of accounts will be in the range [1, 1000].
 * 2. The length of accounts[i] will be in the range [1, 10].
 * 3. The length of accounts[i][j] will be in the range [1, 30].
 */
import java.util.*;
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) return res;
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> union = new HashMap<>();
        for (List<String> a : accounts) {
            String name = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                owner.put(a.get(i), name);
                parents.put(a.get(i), a.get(i));
            }
        }
        for (List<String> a : accounts) {
            String root = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++) {
                parents.put(find(a.get(i), parents), root);
            }
        }
        for (List<String> a : accounts) {
            String root = find(a.get(1), parents);
            if (!union.containsKey(root)) union.put(root, new TreeSet<>());
            for (int i = 1; i < a.size(); i++) {
                union.get(root).add(a.get(i));
            }
        }
        for (String str : union.keySet()) {
            String own = owner.get(str);
            List<String> emails = new ArrayList<>(union.get(str));
            emails.add(0, own);
            res.add(emails);
        }
        return res;
    }
    public String find(String str, Map<String, String> parents) {
        String par = parents.get(str);
        while (par != parents.get(par)) {
            par = parents.get(par);
        }
        return par;
    }
}