class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1) return n;
        int l=0;int r=1;int maxLength=1;
        while(r<n){
            int ind=s.substring(l,r).indexOf(s.charAt(r));
            if(ind!=-1){
                l=l+ind+1;
            }else{
                maxLength=Math.max(maxLength,r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}