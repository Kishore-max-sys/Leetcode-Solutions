class Solution {
    static int mod=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long n1=pow(5,even);
        long n2=pow(4,odd);
        return (int)((n1*n2)%mod);
    }
    long pow(long base,long n){
        if(n==0) return 1;
        long half=pow(base,n/2);
        if(n%2==0){
            return (half*half)%mod;
        }
        return (half*half*base)%mod;
    }
}