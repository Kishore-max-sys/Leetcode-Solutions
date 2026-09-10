class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(nums2[nums2.length-1],-1);
        for(int i=nums2.length-2;i>=0;i--){
            if(nums2[i]<nums2[i+1]){
                map.put(nums2[i],nums2[i+1]);
            }else{
                int temp=nums2[i+1];
                while(map.get(temp)!=-1&&nums2[i]>=map.get(temp)){
                    temp=map.get(temp);
                }
                map.put(nums2[i],map.get(temp));
            }
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}