class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int lr=0;
        int hr=m-1;
        int row=-1;
        while(lr<=hr){
            int mid=(lr+hr)/2;
            if(matrix[mid][0]<=target){
                row=mid;
                lr=mid+1;
            }else{
                hr=mid-1;
            }
        }
        if(row==-1) return false;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}