class MyQueue {
    MyStack input;
    MyStack output;

    public MyQueue() {
        input=new MyStack();
        output=new MyStack();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        moveElements();
        return output.pop();
    }
    
    public int peek() {
        moveElements();
        return output.top();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    public void moveElements(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
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