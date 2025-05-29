import java.util.*;
public class removeDupli {
    public static String removeDuplicaate(String s){
        HashSet<Character> set = new HashSet<>();
        StringBuilder res = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!set.contains(s.charAt(i))){
                res.append(s.charAt(i));
            }
            set.add(s.charAt(i));
        }

        return res.toString();
    }
    public static void main(String[] args) {
        String s = "programming";
        System.out.println(removeDuplicaate(s));
    }
}
