class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=findNSE(heights);
        int[] pse=findPSE(heights);
        long area=0;
        for(int i=0;i<n;i++){
            int left=pse[i];
            int right=nse[i];
            int width=right-left-1;
            area=Math.max(area,(long)heights[i]*width);
        }
        return (int)area;
    }
    int[] findNSE(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
    int[] findPSE(int[] arr){
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        return pse;
    }
}