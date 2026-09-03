class Solution {
    public boolean isIsomorphic(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m!=n) return false;
        int[] arr1=new int[256];
        int[] arr2=new int[256];
        for(int i=0;i<m;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(arr1[ch1]!=0){
                if(arr1[ch1]!=ch2){
                    return false;
                }
            }else{
                arr1[ch1]=ch2;
            }
            if(arr2[ch2]!=0){
                if(arr2[ch2]!=ch1){
                    return false;
                }
            }else{
                arr2[ch2]=ch1;
            }
        }
        return true;
    }
}