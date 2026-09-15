class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1) return n;
        int l=0;int r=1;int maxLength=1;
        int[] arr=new int[128];
        Arrays.fill(arr,-1);
        arr[s.charAt(l)]=0;
        while(r<n){
            char ch=s.charAt(r);
            if(arr[ch]>=l){
                l=arr[ch]+1;
            }else{
                maxLength=Math.max(maxLength,r-l+1);
            }
            arr[ch]=r;
            r++;
        }
        return maxLength;
    }
}