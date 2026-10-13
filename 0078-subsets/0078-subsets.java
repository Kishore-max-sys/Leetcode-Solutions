class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        generateSubset(0,nums,list,ans,nums.length);
        return ans;
    }
    void generateSubset(int ind,int[] nums,List<Integer> list,List<List<Integer>> ans,int n){
        if(ind==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        generateSubset(ind+1,nums,list,ans,n);
        list.remove(list.size()-1);
        generateSubset(ind+1,nums,list,ans,n);
    }
}