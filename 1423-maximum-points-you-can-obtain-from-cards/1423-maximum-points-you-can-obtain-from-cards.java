class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int ans=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        for(int i=0;i<k;i++){
            ans=Math.max(ans,sum);
            sum-=cardPoints[k-i-1];
            sum+=cardPoints[n-1-i];
        }
        ans=Math.max(ans,sum);
        return ans;
    }
}