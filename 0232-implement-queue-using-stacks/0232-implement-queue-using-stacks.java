class MyQueue {
    MyStack s1;
    MyStack s2;

    public MyQueue() {
        s1=new MyStack();
        s2=new MyStack();
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.top();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
class MyStack{
    int[] stack;
    int capacity;
    int top;
    public MyStack(){
        capacity=100;
        stack=new int[capacity];
        top=-1;
    }
    public void push(int x){
        if(top==capacity-1) return;
        top++;
        stack[top]=x;
    }
    public int pop(){
        if(top==-1) return -1;
        int ele=stack[top];
        top--;
        return ele;
    }
    public int top(){
        if(top==-1) return -1;
        return stack[top];
    }
    public boolean isEmpty(){
        if(top==-1) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */