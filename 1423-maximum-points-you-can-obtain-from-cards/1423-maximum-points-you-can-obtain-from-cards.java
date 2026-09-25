class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int[] first=new int[k];
        int i=0;
        int[] last=new int[k];
        int l1=0,r1=0;
        int l2=n-1,r2=n-1;
        int p=0,s=0;
        while(r1<k&&(n-r2-1)<k){
            p+=cardPoints[r1];
            first[i]=p;
            s+=cardPoints[r2];
            last[i]=s;
            i++;
            r1++;
            r2--;
        }
        int ans=0;
        for(int j=0;j<k-1;j++){
            ans=Math.max(ans,first[j]+last[k-j-2]);
        }
        ans=Math.max(ans,Math.max(first[k-1],last[k-1]));
        return ans;
    }
}