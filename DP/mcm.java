public class mcm {
    public static int slove(int []arr, int i, int j){
        if(i>=j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempAns = slove(arr, i, k) + slove(arr,k+1, j) + (arr[i-1] * arr[k] * arr[j]);
            if(tempAns < min){
                min = tempAns;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[] = {40,20,30,10,30};
        System.out.println(slove(arr, 1, arr.length-1));
    }
}
