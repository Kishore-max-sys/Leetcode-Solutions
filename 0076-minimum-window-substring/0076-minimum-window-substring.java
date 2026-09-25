class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n>m) return "";
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int missing=t.length();
        int l=0;
        int r=0;
        int minLength=Integer.MAX_VALUE;
        int minL=-1;
        int minR=-1;
        while(r<m){
            char ch=s.charAt(r);
            if(freq[ch]>0) missing--;
            freq[ch]--;
            while(missing==0&&l<=r&&freq[s.charAt(l)]+1<=0){
                freq[s.charAt(l)]++;
                l++;
            }
            if(missing==0){
                if((r-l+1)<=minLength){
                    minLength=r-l+1;
                    minL=l;
                    minR=r;
                }
            }
            r++;
        }
        if(minL==-1) return "";
        return s.substring(minL,minR+1);
    }
}