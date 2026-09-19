class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums2) set.add(num);
        HashSet<Integer> temp=new HashSet<>();
        for(int num:nums1){
            if(!set.contains(num)) temp.add(num);
        }
        ans.add(new ArrayList<>(temp));
        set.clear();
        for(int num:nums1) set.add(num);
        temp=new HashSet<>();
        for(int num:nums2){
            if(!set.contains(num)) temp.add(num);
        }
        ans.add(new ArrayList<>(temp));
        return ans;
    }
}