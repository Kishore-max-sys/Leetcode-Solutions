class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<>();
        buildParanthesis("",0,0,list,n);
        return list;
    }
    void buildParanthesis(String str,int open,int close,List<String> list,int n){
        if(open==n&&close==n){
            list.add(str);
            return;
        }
        if(open<n){
            buildParanthesis(str+"(",open+1,close,list,n);
        }
        if(close<open){
            buildParanthesis(str+")",open,close+1,list,n);
        }
    }
}