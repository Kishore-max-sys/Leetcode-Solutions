class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        combinationGenerator(0,candidates,candidates.length,0,target,list,ans);
        return ans;
    }
    void combinationGenerator(int ind,int[] candidates,int n,int sum,int target,List<Integer> list,List<List<Integer>> ans){
        if(sum>target) return;
        else if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind==n){
            if(sum==target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(candidates[ind]);
        sum+=candidates[ind];
        combinationGenerator(ind+1,candidates,n,sum,target,list,ans);
        list.remove(list.size()-1);
        sum-=candidates[ind];
        int next=ind+1;
        while(next<n&&candidates[next]==candidates[next-1]){
            next++;
        }
        combinationGenerator(next,candidates,n,sum,target,list,ans);
    }
}