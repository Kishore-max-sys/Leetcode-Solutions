class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length()>num2.length()){
            return addStrings(num2, num1);
        }
        StringBuilder sb=new StringBuilder();
        int carry=0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        while(i>=0){
            int sum=(num2.charAt(j)-'0')+(num1.charAt(i)-'0')+carry;
            carry=sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }
        while(j>=0){
            int sum=num2.charAt(j)-'0'+carry;
            carry=sum/10;
            sb.append(sum%10);
            j--;
        }
        if(carry>0) sb.append(carry);
        sb=sb.reverse();
        return sb.toString();
    }
}