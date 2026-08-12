class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int low=0;
        int high=m;
        int left=(m+n+1)/2;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int left1=Integer.MIN_VALUE,left2=Integer.MIN_VALUE;
            int right1=Integer.MAX_VALUE,right2=Integer.MAX_VALUE;
            if(mid1<m) right1=nums1[mid1];
            if(mid2<n) right2=nums2[mid2];
            if(mid1>0) left1=nums1[mid1-1];
            if(mid2>0) left2=nums2[mid2-1];
            if(left1<=right2 && left2<=right1){
                if((m+n)%2!=0) return Math.max(left1,left2);
                else return (double)(Math.max(left1,left2)+Math.min(right1,right2))/2;
            }
            else if(left1>right2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0;
    }
}