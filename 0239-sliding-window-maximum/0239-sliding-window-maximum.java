class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int t=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.peekLast()>=k-1){
                ans[t]=nums[dq.peekFirst()];
                t++;
            }
        }
        return ans;
    }
}