class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] prefixSum=new int[m][n];
        int maxArea=0;
        for(int j=0;j<n;j++){
            int sum=0;
            for(int i=0;i<m;i++){
                sum+=(matrix[i][j]-'0');
                if(matrix[i][j]=='0') sum=0;
                prefixSum[i][j]=sum;
            }
        }
        for(int i=0;i<m;i++){
            maxArea=Math.max(maxArea,largeRectHist(prefixSum[i]));
        }
        return maxArea;
    }
    int largeRectHist(int[] arr){
        int n=arr.length;
        int area=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                int ele=arr[st.peek()];
                st.pop();
                int left=st.isEmpty()?-1:st.peek();
                int right=i;
                int width=right-left-1;
                area=Math.max(area,ele*width);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele=arr[st.peek()];
            st.pop();
            int left=st.isEmpty()?-1:st.peek();
            int right=n;
            int width=right-left-1;
            area=Math.max(area,ele*width);
        }
        return area;
    }
}