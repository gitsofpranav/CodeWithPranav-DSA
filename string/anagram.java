import java.util.Arrays;

public class anagram {

    //Brute Force 
    //T.C = O(nlogn);
    // S.C  = O(n+m);
    public static boolean isAmagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char []arr1 = s1.toCharArray();
        char []arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }

    //Optimized

    public static boolean isAmagram2(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int []freq = new int[26];

        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for(int count : freq){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "sielnt";
        System.out.println(isAmagram(s1, s2));
        System.out.println(isAmagram2(s1, s2));
    }
}
