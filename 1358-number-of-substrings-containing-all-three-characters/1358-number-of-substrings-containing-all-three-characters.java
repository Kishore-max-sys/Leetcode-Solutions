class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;
        int[] freq=new int[3];
        int l=0;
        int r=0;
        while(r<n){
            freq[s.charAt(r)-'a']++;
            while(freq[0]>0&&freq[1]>0&&freq[2]>0){
                count+=n-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return count;
    }
}