class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!st.isEmpty()&&st.peek().ele<=price){
            count+=st.peek().span;
            st.pop();
        }
        st.push(new Pair(price,count));
        return count;
    }
}
class Pair{
    int ele;
    int span;
    Pair(int ele,int span){
        this.ele=ele;
        this.span=span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */