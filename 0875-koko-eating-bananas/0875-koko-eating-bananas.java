class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int num: piles){
            if(num>max){
                max=num;
            }
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
    long calTime(int[] arr,int ele){
        long total=0;
        for(int i=0;i<arr.length;i++){
            total+=(int)Math.ceil((double)arr[i]/ele);
        }
        return total;
    }
}