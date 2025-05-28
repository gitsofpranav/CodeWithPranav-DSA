public class v2Palindrome {
    public static boolean isPalindromeVersion2(String s){
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str.append(Character.toLowerCase(ch));
            }
        }

        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "racer a car";
        String s2 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeVersion2(s));
        System.out.println(isPalindromeVersion2(s2));
    }
}
