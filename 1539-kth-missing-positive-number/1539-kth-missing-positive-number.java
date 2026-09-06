class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;

        if(arr[0]>k) return k;

        int miss=arr[n-1]-n;
        if(miss<k) return arr[n-1]+k-miss;
        
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            miss=arr[mid]-(mid+1);
            if(miss>=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        int more=k-(arr[high]-(high+1));
        return arr[high]+more;
    }
}