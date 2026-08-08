class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int weight:weights){
            max=Math.max(max,weight);
            sum+=weight;
        }
        int low=max;
        int high=sum;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int count=1;
            int tw=0;
            for(int weight:weights){
                if(tw+weight>mid){
                    count++;
                    tw=0;
                }
                tw+=weight;
            }
            if(count<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}