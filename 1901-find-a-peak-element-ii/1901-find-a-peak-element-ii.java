class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] arr={-1,-1};
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int left=-1,right=-1;
            int max=Integer.MIN_VALUE;
            int maxRow=-1;
            for(int i=0;i<m;i++){
                if(mat[i][mid]>max){
                    max=mat[i][mid];
                    maxRow=i;
                }
            }
            if(mid>0) left=mat[maxRow][mid-1];
            if(mid<n-1) right=mat[maxRow][mid+1];
            if(max>left && max>right){
                arr[0]=maxRow;
                arr[1]=mid;
                return arr;
            }else if(left>max){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return arr;
    }
}