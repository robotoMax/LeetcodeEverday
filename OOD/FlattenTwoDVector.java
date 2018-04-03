/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * implement an iterator to flatten a 2d vector.
 * For example,
 * Given 2d vector =
 * 
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
import java.util.*;
public class FlattenTwoDVector implements Iterator<Integer> {

    Iterator<List<Integer>> iterators;
    Iterator<Integer> iter;

    public FlattenTwoDVector(List<List<Integer>> vec2d) {
        iterators = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        while ((iter == null || !iter.hasNext()) && iterators.hasNext()) {
            iter = iterators.next().iterator();
        }
        return iter != null && iter.hasNext();
    }
}