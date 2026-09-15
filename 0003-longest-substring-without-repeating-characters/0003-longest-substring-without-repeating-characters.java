class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1) return n;
        int l=0;int r=1;int maxLength=1;
        HashMap<Character,Integer> map=new HashMap<>();
        map.put(s.charAt(l),0);
        while(r<n){
            char ch=s.charAt(r);
            if(map.containsKey(ch)&&map.get(ch)>=l){
                l=map.get(ch)+1;
            }else{
                maxLength=Math.max(maxLength,r-l+1);
            }
            map.put(ch,r);
            r++;
        }
        return maxLength;
    }
}