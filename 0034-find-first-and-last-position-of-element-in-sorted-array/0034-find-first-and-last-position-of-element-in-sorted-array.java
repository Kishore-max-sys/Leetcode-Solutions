class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr=new int[2];
        int n=nums.length;
        int low=0;
        int high=n-1;
        int first=-1;
        int last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                if(nums[mid]==target) first=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        low=0;
        high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=target){
                if(nums[mid]==target) last=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        arr[0]=first;
        arr[1]=last;
        return arr;
    }
}