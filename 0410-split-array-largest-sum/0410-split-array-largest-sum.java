class Solution {
    public int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        int low=max;
        int high=sum;
        int ans=high;
        while(low<=high){
            int mid=(low+high)/2;
            int i=0;
            int count=1;
            int s=0;
            while(i<nums.length){
                if(count>k){
                    break;
                }
                if(s+nums[i]>mid){
                    count++;
                    s=nums[i];
                }else{
                    s+=nums[i];
                }
                i++;
            }
            if(count<=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}