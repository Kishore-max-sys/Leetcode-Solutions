class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysLessEqualK(nums,k)-numberOfSubarraysLessEqualK(nums,k-1);
    }
    int numberOfSubarraysLessEqualK(int[] nums,int k){
        int n=nums.length;
        int count=0;
        int sub=0;
        int l=0;
        int r=0;
        while(r<n){
            if(nums[r]%2!=0) count++;
            while(count>k){
                if(nums[l]%2!=0) count--;
                l++;
            }
            sub+=(r-l+1);
            r++;
        }
        return sub;
    }
}