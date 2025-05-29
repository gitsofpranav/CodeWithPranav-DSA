import java.util.*;
public class longesSubStr {
    public static int longestSubStr(String s){
        if(s.length() == 1){
            return 1;
        }
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right=0; right<s.length(); right++){

            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left+1);
        }

        return maxLen;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(longestSubStr(s));
    }
}
