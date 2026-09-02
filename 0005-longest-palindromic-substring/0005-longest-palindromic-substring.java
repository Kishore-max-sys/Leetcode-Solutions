class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        ans.append(s.charAt(0));
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                int left=i-j;
                int right=i+1;
                while(left>=0&&right<n){
                    if(s.charAt(left)==s.charAt(right)){
                        String sub=s.substring(left,right+1);
                        if(ans.length()<sub.length()){
                            ans=new StringBuilder(sub);
                        }
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }
}