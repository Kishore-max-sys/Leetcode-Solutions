class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count=1;
        String temp=a;
        while(a.length()<b.length()){
            a+=temp;
            count++;
        }
        for(int i=0;i<2;i++){
            boolean isMatch=RabinKarp(a,b);
            if(isMatch){
                return count;
            }
            a+=temp;
            count++;
        }
        return -1;
    }
    boolean RabinKarp(String s,String pattern){
        int n=s.length();
        int m=pattern.length();
        if(n<m) return false;
        int base=26;
        int mod=1_000_000_007;
        long textHash=0;
        long patternHash=0;
        long power=1;
        for(int i=0;i<m;i++){
            patternHash=(patternHash*base+pattern.charAt(i))%mod;
            textHash=(textHash*base+s.charAt(i))%mod;
        }
        for(int i=0;i<m-1;i++){
            power=(power*base)%mod;
        }
        for(int i=0;i<=n-m;i++){
            if(textHash==patternHash){
                if(s.substring(i,i+m).equals(pattern)){
                    return true;
                }
            }
            if(i<n-m){
                textHash=(textHash-s.charAt(i)*power)%mod;
                if(textHash<0){
                    textHash+=mod;
                }
                textHash=(textHash*base+s.charAt(i+m))%mod;
            }
        }
        return false;
    }
}