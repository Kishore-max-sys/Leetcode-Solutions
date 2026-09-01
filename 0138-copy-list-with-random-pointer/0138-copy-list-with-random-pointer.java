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
        Node temp=head;
        Node node=new Node(head.val);
        Node head1=node;
        while(temp.next!=null){
            Node nextNode=new Node(temp.next.val);
            node.next=nextNode;
            node=node.next;
            temp=temp.next;
        }
        node.next=null;
        temp=head;
        Node temp2=head1;
        while(temp!=null){
            if(temp.random==null){
                temp2.random=null;
                temp=temp.next;
                temp2=temp2.next;
                continue;
            }
            Node randomNode=temp.random;
            Node temp3=head;
            Node temp4=head1;
            while(temp3!=randomNode){
                temp3=temp3.next;
                temp4=temp4.next;
            }
            temp2.random=temp4;
            temp=temp.next;
            temp2=temp2.next;
        }
        return head1;
    }
}