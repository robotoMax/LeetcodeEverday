/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be 
 * represented as some "#XYZ"
 * Example 1:
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:  
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 * This is the highest among any shorthand color.
 * Note:
 * 1. color is a string of length 7.
 * 2. color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 * 3. Any answer which has the same (highest) similarity as the best answer will be accepted.
 * 4. All inputs and outputs should use lowercase letters, and the output is 7 characters.
 */
public class SimilarRGBColor {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < color.length(); i += 2) {
            sb.append(helper(color.charAt(i), color.charAt(i + 1)));
        } 
        return sb.toString();
    }
    public String helper(char a, char b) {
        int x = Character.isDigit(a) ? (a - '0') : (a - 'a' + 10);
        int y = Character.isDigit(b) ? (b - '0') : (b - 'a' + 10);
        int sum = x * 16 + y;
        int index = sum / 17;
        int remainder = sum % 17;
        if (remainder > 17 / 2) index++;
        char c = (index < 10) ? ((char) (index + '0')) : ((char) (index - 10 + 'a'));
        return String.valueOf(c) + String.valueOf(c);
    }
}