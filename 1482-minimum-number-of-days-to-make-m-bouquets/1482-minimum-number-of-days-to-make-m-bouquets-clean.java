class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int day:bloomDay){
            min=Math.min(day,min);
            max=Math.max(day,max);
        }
        int low=min;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int flowers=0;
            int bouquets=0;
            for(int day : bloomDay){
                if(day<=mid){
                    flowers++;
                    if(flowers==k){
                        bouquets++;
                        flowers=0;
                    }
                }else{
                    flowers=0;
                }
            }
            if(bouquets>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}