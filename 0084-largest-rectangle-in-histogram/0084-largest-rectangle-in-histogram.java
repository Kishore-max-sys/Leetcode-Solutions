class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        long area=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
                int ele=heights[st.peek()];
                st.pop();
                int right=i;
                int left=st.isEmpty()?-1:st.peek();
                int width=right-left-1;
                area=Math.max(area,(long)ele*width);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int right=n;
            int ele=heights[st.peek()];
            st.pop();
            int left=st.isEmpty()?-1:st.peek();
            int width=right-left-1;
            area=Math.max(area,(long)ele*width);
        }
        return (int)area;
    }
}