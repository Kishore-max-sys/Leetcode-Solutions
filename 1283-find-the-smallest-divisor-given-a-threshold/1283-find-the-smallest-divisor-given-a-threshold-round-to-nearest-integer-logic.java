class Solution {
    public int smallestDivisor(int[] nums, int threshold){
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int result=0;
            for(int num :nums){
                result+=(num+mid-1)/mid;
            }
            if(result<=threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}