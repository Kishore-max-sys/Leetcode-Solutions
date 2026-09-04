class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            if(low<n-1 && nums[low]!=nums[low+1]){
                return nums[low];
            }else if(high>0 && nums[high]!=nums[high-1]){
                return nums[high];
            }else{
                low+=2;
                high-=2;
            }
        }
        return nums[0];
    }
}