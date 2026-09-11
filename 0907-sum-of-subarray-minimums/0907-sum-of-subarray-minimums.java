class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long total=0;
        int mod=1000000007;
        int[] nse=findNSE(arr);
        int[] psee=findPSEE(arr);
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(total+((long)left*right*arr[i])%mod)%mod;
        }
        return (int)total;
    }
    int[] findNSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
    int[] findPSEE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] psee=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()) psee[i]=-1;
            else psee[i]=st.peek();
            st.push(i);
        }
        return psee;
    }
}