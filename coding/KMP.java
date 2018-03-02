import java.util.Arrays;

public class KMP {

    // the way to know if a string contains another string as its substring

    private static int[] computeTemporaryArray(char pattern[]) {
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                    System.out.println(index);
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static boolean kmp(String text, String pat) {
        int[] res = computeTemporaryArray(pat.toCharArray());
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pat.length()) {
            if (pat.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            else {
                if (j != 0) {
                    j = res[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        return j == pat.length();
    }

    public static void main(String[] args) {
        String s = "ababc";
        // System.out.println(Arrays.toString(computeTemporaryArray(s.toCharArray())));
        String t = "abc";
        System.out.println(kmp(s, t));
    }
}