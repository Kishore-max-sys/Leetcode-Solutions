class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int[] nge=findNGE(nums);
        int[] pgee=findPGEE(nums);
        int[] nse=findNSE(nums);
        int[] psee=findPSEE(nums);
        long total=0;
        long largest=0;
        long smallest=0;
        for(int i=0;i<n;i++){
            int left1=i-pgee[i];
            int right1=nge[i]-i;
            int left2=i-psee[i];
            int right2=nse[i]-i;
            total=total+(long)left1*right1*nums[i]-(long)left2*right2*nums[i];
        }
        return total;
    }
    int[] findNGE(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nge[i]=n;
            else nge[i]=st.peek();
            st.push(i);
        }
        return nge;
    }
    int[] findPGEE(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] pgee=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[i]>nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) pgee[i]=-1;
            else pgee[i]=st.peek();
            st.push(i);
        }
        return pgee;
    }
    int[] findNSE(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[i]<=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nge[i]=n;
            else nge[i]=st.peek();
            st.push(i);
        }
        return nge;
    }
    int[] findPSEE(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] psee=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[i]<nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) psee[i]=-1;
            else psee[i]=st.peek();
            st.push(i);
        }
        return psee;
    }
}