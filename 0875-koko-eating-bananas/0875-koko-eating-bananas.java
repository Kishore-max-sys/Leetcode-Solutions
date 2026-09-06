class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int pile: piles){
            max=Math.max(pile,max);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            long time=calTime(piles,mid);
            if(time<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    long calTime(int[] piles,int k){
        long total=0;
        for(int pile:piles){
            total+=(pile+k-1)/k;
        }
        return total;
    }
}