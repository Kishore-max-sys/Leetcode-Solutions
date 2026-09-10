class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[10001];
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty()&&nums2[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()) nge[nums2[i]]=-1;
            else nge[nums2[i]]=st.peek();
            st.push(nums2[i]);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=nge[nums1[i]];
        }
        return ans;
    }
}