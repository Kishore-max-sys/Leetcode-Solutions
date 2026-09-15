class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int maxLength=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(r<n){
            if(nums[r]==1){
                maxLength=Math.max(maxLength,r-l+1);
            }else{
                if(k>0){
                    list.add(r);
                    k--;
                    maxLength=Math.max(maxLength,r-l+1);
                }else{
                    if(list.size()>0){
                        l=list.get(0)+1;
                        list.remove(0);
                        list.add(r);
                    }else{
                        l=r+1;
                    }
                }
            }
            r++;
        }
        return maxLength;
    }
}