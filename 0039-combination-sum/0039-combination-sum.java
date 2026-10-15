class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combinationGenerator(0,candidates,candidates.length,0,target,list,ans);
        return ans;
    }
    void combinationGenerator(int ind,int[] candidates,int n,int sum,int target,List<Integer> list,List<List<Integer>> ans){
        if(ind==n){
            if(sum==target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        int count=0;
        while(sum+candidates[ind]<=target){
            count++;
            list.add(candidates[ind]);
            sum+=candidates[ind];
            combinationGenerator(ind+1,candidates,n,sum,target,list,ans);
        }
        list.removeIf(x -> x==candidates[ind]);
        sum-=count*candidates[ind];
        combinationGenerator(ind+1,candidates,n,sum,target,list,ans);
    }
}