class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums1) set.add(num);
        int n=set.size();
        int[] arr=new int[n];
        int i=0;
        for(int num:nums2){
            if(i>=n) break;
            if(set.contains(num)){
                arr[i]=num;
                i++;
                set.remove(num);
            }
        }
        return Arrays.copyOf(arr,i);
    }
}