class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int a:asteroids){
            boolean isAlive=true;
            while(!st.isEmpty()&&st.peek()>0&&a<0&&isAlive){
                if(st.peek()<-a){
                    st.pop();
                }else if(st.peek()==-a){
                    st.pop();
                    isAlive=false;
                }else{
                    isAlive=false;
                }
            }
            if(isAlive) st.push(a);
        }
        int[] ans=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i]=st.peek();
            i--;
            st.pop();
        }
        return ans;
    }
}