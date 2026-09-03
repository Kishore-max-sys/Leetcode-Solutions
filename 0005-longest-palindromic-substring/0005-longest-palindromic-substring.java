class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                int left=i-j;
                int right=i+1;
                while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }
                if(max<(right-left-1)){
                    max=(right-left-1);
                    start=left+1;
                }
            }
        }
        return s.substring(start,start+max);
    }
}