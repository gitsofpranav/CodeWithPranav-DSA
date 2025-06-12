public class print{
    public static void printNum(int n){
        if(n==0){
           return;
        }
        System.out.println(n);
        printNum(n-1);
        // System.out.println(n);
    }
    public static void main(String [] args){
        int n =10;
        printNum(n);
    }
}