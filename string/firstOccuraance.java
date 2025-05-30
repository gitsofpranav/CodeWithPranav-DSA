public class firstOccuraance {
    public static int occurance(String h, String needle){
        int n = h.length();
        int m = needle.length();
        if(n == 0){
            return -1;
        }

        for(int i=0; i<n-m; i++){
            if(h.substring(i, i+m).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String hayStack = "hello";
        String needle = "ll";
        System.out.println(occurance(hayStack, needle));
    }
}
