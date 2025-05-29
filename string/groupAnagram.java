import java.util.*;
public class groupAnagram {
    public static List<List<String>> group(String [] str){
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<str.length; i++){
            String word = str[i];
            char [] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }

            map.get(sorted).add(word);
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String [] str = {"eat", "tea","tan","ate","nat","bat"};
        System.out.println(group(str));
    }
}
