public class reverse {
    public static String reversedStr(String s){
        StringBuilder reversed  = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reversedStr(s));
    }
}
