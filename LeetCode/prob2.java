import java.util.*;
class Solution {
    private boolean check(int val, int p, int[] nums){
        int i=0, n=nums.length;
        while (i+1<n){
            if (nums[i+1]-nums[i]<=val) {
                p--;
                if (p<=0) return true;
                i+=2;
            }
            else i++;
        }
        return false;
    }
    public int minimizeMax(int[] nums, int p) {
        if (p==0) return 0;
        Arrays.sort(nums);
        int n=nums.length, l=0, r=nums[n-1]-nums[0], ans=0;
        while (l<=r){
            int mid=(l+r)/2;
             if (check(mid,p,nums)){
                ans=mid;
                r=mid-1;
             }
             else l=mid+1;
        }
        return ans;
    }
}