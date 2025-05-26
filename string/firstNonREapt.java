public class firstNonREapt {
    public static int firstNonRepatingCharater(String s){
        int []freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;

        }

        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }


    public static void firstNonRepatingCharater2(String s){
        int []freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;

        }

        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                System.out.println(s.charAt(i));
                return;
            }
        }
        System.out.println("not found");
    }
    public static void main(String[] args) {
        String s = "llheetcode";
        System.out.println(firstNonRepatingCharater(s));
        System.out.println();
        firstNonRepatingCharater2(s);

    }
}
