class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            if(low<n-1 && nums[low]>nums[low+1]){
                return low;
            }else if(high>0 && nums[high]>nums[high-1]){
                return high;
            }else{
                low++;
                high--;
            }
        }
        return 0;
    }
}