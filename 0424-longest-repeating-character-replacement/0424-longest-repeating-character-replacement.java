class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength=0;
        int l=0;
        int r=0;
        int[] hash=new int[26];
        int maxFreq=0;
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,hash[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxFreq<=k){
                maxLength=Math.max(maxLength,r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}