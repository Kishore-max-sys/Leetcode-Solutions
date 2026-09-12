class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(k==n) return "0";
        Stack<Integer> st=new Stack<>();
        for(char ch:num.toCharArray()){
            int val=ch-'0';
            while(!st.isEmpty()&&val<st.peek()&&k>0){
                st.pop();
                k--;
            }
            st.push(val);
        }
        while(!st.isEmpty()&&k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(String.valueOf(st.peek()));
            st.pop();
        }
        sb=sb.reverse();
        while(sb.length()>1&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}