/**
 * 
 * Date: 03/18/2018
 * Created By: Shuai Liu
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(new String[] {"", ".", ".."}));
        for (String p : path.split("/")) {
            if (!stack.isEmpty() && p.equals("..")) stack.pop();
            else {
                if (!set.contains(p)) stack.push(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String temp = "/" + stack.pop();
            sb.insert(0, temp);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}