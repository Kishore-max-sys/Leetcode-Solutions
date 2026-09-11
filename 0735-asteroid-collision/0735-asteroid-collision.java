class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]<0){
                boolean isAlive=true;
                while(!st.isEmpty()&&st.peek()>0){
                    int big=Math.max(st.peek(),Math.abs(asteroids[i]));
                    if(big==st.peek()){
                        if(big==Math.abs(asteroids[i])){
                            st.pop();
                        }
                        isAlive=false;
                        break;
                    }
                    else{
                        st.pop();
                    }
                }
                if(isAlive){
                    st.push(asteroids[i]);
                }
            }else{
                st.push(asteroids[i]);
            }
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