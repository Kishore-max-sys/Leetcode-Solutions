class Solution {
    public boolean isValid(String s) {
        MyStack obj=new MyStack(s.length());
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                obj.push(ch);
            }else{
                char ele=obj.pop();
                char open='a';
                switch (ch){
                    case ')':
                    open='(';
                    break;
                    case ']':
                    open='[';
                    break;
                    case '}':
                    open='{';
                    break;
                }
                if(open!=ele) return false;
            }
        }
        if(obj.isEmpty()) return true;
        return false;
    }
}
class MyStack{
    char[] stack;
    int capacity;
    int top;
    MyStack(int capacity){
        this.capacity=capacity;
        stack=new char[capacity];
        top=-1;
    }
    void push(char x){
        if(top==capacity-1) return;
        top++;
        stack[top]=x;
    }
    char pop(){
        if(top==-1) return 'a';
        char ele=stack[top];
        top--;
        return ele;
    }
    boolean isEmpty(){
        if(top==-1) return true;
        return false;
    }
}