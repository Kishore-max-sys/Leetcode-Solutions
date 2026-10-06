class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtleastKDistinct(nums,k)-subarraysWithAtleastKDistinct(nums, k-1);
    }
    int subarraysWithAtleastKDistinct(int[] nums, int k){
        int n=nums.length;
        int count=0;
        int l=0;
        int r=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }
}