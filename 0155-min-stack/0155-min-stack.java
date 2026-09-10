class MinStack {
    Stack<Pair> minStack;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        minStack=new Stack<>();
    }
    
    public void push(int value) {
        min=Math.min(value,min);
        minStack.push(new Pair(value,min));
    }
    
    public void pop() {
        minStack.pop();
        if(minStack.isEmpty()) min=Integer.MAX_VALUE;
        else min=minStack.peek().min;
    }
    
    public int top() {
        return minStack.peek().ele;
    }
    
    public int getMin() {
        return minStack.peek().min;
    }
}

class Pair{
    int ele;
    int min;
    Pair(int ele,int min){
        this.ele=ele;
        this.min=min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */