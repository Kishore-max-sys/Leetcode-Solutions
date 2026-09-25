class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int l1=0,r1=0;
        int l2=n-1,r2=n-1;
        int p=0,s=0;
        while(r1<k){
            p+=cardPoints[r1];
            r1++;
        }
        r1--;
        int ans=0;
        while(r1>=0){
            ans=Math.max(ans,p+s);
            p-=cardPoints[r1];
            s+=cardPoints[r2];
            r1--;
            r2--;
        }
        ans=Math.max(ans,s);
        return ans;
    }
}