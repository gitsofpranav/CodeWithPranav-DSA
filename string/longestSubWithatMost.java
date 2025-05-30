import java.util.*;
public class longestSubWithatMost {
    public static int longestSubStingwithAtmost(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right = 0; right <s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            while(map.size()>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(longestSubStingwithAtmost(s, k));
    }
}
