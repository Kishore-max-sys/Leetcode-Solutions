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
            int count=0;
            int i=0;
            while(i<n){
                if(k==1){
                    if(bloomDay[i]<=mid){
                        count++;
                    }
                    i++;
                    continue;
                }
                int t=k-1;
                while(t!=0){
                    if(i<n-1 && bloomDay[i]<=mid && bloomDay[i+1]<=mid){
                        t--;
                        i++;
                    }else{
                        i++;
                        break;
                    }
                }
                if(t==0){
                    count++;
                    i++;
                }
            }
            if(count>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}