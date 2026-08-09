class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int max=arr[n-1];
        int count=0;
        for(int i=1;i<max+k;i++){
            if(!binarySearch(arr,0,n-1,i)){
                count++;
                if(count==k){
                    return i;
                }
            }
        }
        return max+k;
    }
    boolean binarySearch(int[] arr,int low,int high,int ele){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==ele){
                return true;
            }else if(arr[mid]<ele){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}
