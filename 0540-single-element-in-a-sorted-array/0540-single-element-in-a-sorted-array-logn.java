class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid%2==1&&mid!=n-1){
                mid++;
            }
            if(mid<n-1&&nums[mid]==nums[mid+1]){
                low=mid+2;
            }else if(mid>0&&nums[mid]==nums[mid-1]){
                high=mid-2;
            }else{
                return nums[mid];
            }
        }
        return nums[0];
    }
}