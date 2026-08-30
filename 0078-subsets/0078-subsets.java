class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=1<<nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            int x=i;
            for(int j=0;j<nums.length;j++){
                if((x&1)==1){
                    temp.add(nums[j]);
                }
                x>>=1;
            }
            ans.add(temp);
        }
        return ans;
    }
}