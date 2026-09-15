class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int maxLength=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(r<n){
            if(nums[r]==0){
                k--;
            }
            while(k<0){
                if(nums[l]==0){
                    k++;
                }
                l++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}