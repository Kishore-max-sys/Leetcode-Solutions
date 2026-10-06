class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;
        int[] lastIndex={-1,-1,-1};
        for(int i=0;i<n;i++){
            lastIndex[s.charAt(i)-'a']=i;
            if(lastIndex[0]!=-1&&lastIndex[1]!=-1&&lastIndex[2]!=-1){
                count=count+Math.min(lastIndex[0],Math.min(lastIndex[1],lastIndex[2]))+1;
            }
        }
        return count;
    }
}