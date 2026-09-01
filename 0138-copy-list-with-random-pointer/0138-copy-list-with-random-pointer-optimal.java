/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Integer> map1=new HashMap<>();
        HashMap<Integer,Node> map2=new HashMap<>();
        int index=0;
        Node temp=head;
        while(temp!=null){
            map1.put(temp,index);
            Node newNode=new Node(temp.val);
            map2.put(index,newNode);
            temp=temp.next;
            index++;
        }
        temp=head;
        for(int i=0;i<index-1;i++){
            Node temp2=map2.get(i);
            temp2.next=map2.get(i+1);
            if(map1.containsKey(temp.random)){
                temp2.random=map2.get(map1.get(temp.random));
            }else{
                temp2.random=null;
            }
            temp=temp.next;
            temp2=temp2.next;
        }
        Node last=map2.get(index-1);
        last.next=null;
        if(map1.containsKey(temp.random)){
            last.random=map2.get(map1.get(temp.random));
        }else{
            last.random=null;
        }
        return map2.get(0);
    }
}