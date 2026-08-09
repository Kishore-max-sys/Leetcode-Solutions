class Solution {
    public int findKthPositive(int[] arr, int k) {
        int pos=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int miss=arr[mid]-(mid+1);
            if(miss>=k){
                pos=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        if(pos==-1){
            return arr.length+k;
        }
        int ans=k+pos;
        return ans;
    }
}