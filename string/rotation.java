public class rotation {

    public static boolean isRotated(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        String combined = s1+ s1;
        if(combined.contains(s2)){
            return true;
        }

        return false;
    }
    public static void main(String [] args){
        String s1 = "abcd";
        String s2 = "adcb";
        System.out.println(isRotated(s1, s2));

    }
}
