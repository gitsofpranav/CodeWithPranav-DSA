public class palindrome{
    //T.C = O(n^2)   S.C = O(n)
    public static boolean isPalindrome(String s){
        String reversed = "";
        for(int i = s.length()-1; i>= 0; i--){
            reversed += s.charAt(i);
        }

        if(reversed.equals(s)){
            return true;
        }

        return false;
    }

//   T.C  = O(n)      S.C = O(n)

     public static boolean isPalindrome2(String s){
        StringBuilder reversed = new StringBuilder();
        for(int i = s.length()-1; i>= 0; i--){
            reversed.append(s.charAt(i));
        }

     

        return reversed.toString().equals(s);
    }


     public static boolean isPalindrome3(String s){
       int left = 0; 
       int right = s.length()-1;
       while(left < right){
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }

        left++;
        right--;
       }

       return true;
    }
    public static void main(String[] args){
        String s = "helolleh";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
        System.out.println(isPalindrome3(s));
    }
}