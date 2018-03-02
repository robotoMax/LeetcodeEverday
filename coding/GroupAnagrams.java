import java.util.*;
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] anagrams = new String[]{"aabbcc","ab","bbaa","aabccd","abcdd"};
        String[] anagrams2 = new String[anagrams.length];
        List<String> strings = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count = 1;
        for(int i=0; i<anagrams.length; i++){
            //	String distStr = distinctCHarStr(anagrams[i]);
            //	strings.add(distinctCHarStr(anagrams[i]));
            anagrams2[i] = distinctCHarStr(anagrams[i]);
        }
        for(int j=0; j<anagrams2.length; j++){
            if(map.isEmpty() || !map.containsKey(anagrams2[j])){
                map.put(anagrams2[j], 1);
            } else{
                if (map.containsKey(anagrams2[j])){
                    count = map.get(anagrams2[j]);
                    map.put(anagrams2[j], ++count);
                }
    
            }
    
        }
        for(String word : map.keySet()){
            System.out.println(word+" : "+map.get(word));
        }
    }
    
    private static String distinctCHarStr(String str){
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<Character>(str.length());
        char[] chars1 = new char[str.length()];
        chars1 = str.toCharArray();
        for(char c : chars1){
            set.add(c);
        }
        for(char c : set)
            sb.append(c);
    
        return sb.toString();
    }
}