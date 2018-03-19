/**
 * 
 * Date: 03/18/2018
 * Created By: Shuai Liu
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) 
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when 
 * necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly 
 * between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
import java.util.*;
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int index = 0;
        while (index  < words.length) {
            int count = words[index].length();
            int next = index + 1; // always points to the next word;
            // add as many words as possible: gready
            while (next < words.length) {
                if (count + words[next].length() + 1 > maxWidth) break;
                count += words[next].length() + 1;
                next++;
            }
            StringBuilder sb = new StringBuilder();
            int diff = next - index - 1;
            // if this is the last line or there is only one word in this line
            if (next == words.length || diff == 0) {
                for (int i = index; i < next; i++) sb.append(words[i]).append(" ");
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) sb.append(" ");
            }
            else {
                int spaces = (maxWidth - count + diff) / diff;
                int remain = (maxWidth - count + diff) % diff;
                String temp = "";
                for (int i = 0; i < spaces; i++) temp += " ";
                for (int i = index; i < next; i++) {
                    sb.append(words[i]);
                    if (i - index < remain) sb.append(temp).append(" ");
                    else if (i < next - 1) sb.append(temp);
                }
            }
            res.add(sb.toString());
            index = next;
        }
        return res;
    }
}