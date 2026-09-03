class MyStack {
    MyQueue q;
    public MyStack() {
        q=new MyQueue();
    }
    
    public void push(int x) {
        q.push(x);
        int s=q.size;
        for(int i=1;i<s;i++){
            q.push(q.top());
            q.pop();
        }
    }
    
    public int pop() {
        return q.pop();
    }
    
    public int top() {
        return q.top();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
class MyQueue{
    int[] queue;
    int capacity;
    int start;
    int end;
    int size;
    public MyQueue(){
        capacity=101;
        queue=new int[capacity];
        start=-1;
        end=-1;
        size=0;
    }
    public void push(int x){
        if(size==capacity) return;
        if(start==-1) start++;
        end=(end+1)%capacity;
        size++;
        queue[end]=x;
    }
    public int pop(){
        if(size==0) return -1;
        int ele=queue[start];
        if(size==1){
            end=-1;
            start=-1;
        }else{
            start=(start+1)%capacity;
        }
        size--;
        return ele;
    }
    public int top(){
        if(size==0) return 0;
        return queue[start];
    }
    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */