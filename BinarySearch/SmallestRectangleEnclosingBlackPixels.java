/**
 * 
 * Date: 03/31/2018
 * Created By: Shuai Liu
 * 
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, 
 * i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one 
 * of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * 
 * For example, given the following image:
 * [
 *   "0010",
 *   "0110",
 *   "0100"
 * ]
 * and x = 0, y = 2,
 * Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int left = searchCol(image, 0, y, 0, m, true);
        int right = searchCol(image, y + 1, n, 0, m, false);
        int top = searchRow(image, 0, n, 0, x, true);
        int bot = searchRow(image, 0, n, x + 1, m, false);
        return (right - left) * (bot - top);
    }
    public int searchCol(char[][] image, int left, int right, int top, int bot, boolean findOne) {
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int k = top;
            while (k < bot && image[k][mid] == '0') k++;
            if (k < bot == findOne) {
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
    public int searchRow(char[][] image, int left, int right, int top, int bot, boolean findOne) {
        while (top < bot) {
            int mid = (bot - top) / 2 + top;
            int k = left;
            while (k < right && image[mid][k] == '0') k++;
            if (k < right == findOne) {
                bot = mid;
            }
            else top = mid + 1;
        }
        return top;
    } 
}
