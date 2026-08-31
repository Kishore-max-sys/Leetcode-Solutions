/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k%=n;
        if(k==0) return head;
        ListNode[] nodes;
        nodes=reverse(head);
        ListNode head1=nodes[0];
        temp=head1;
        int count=k;
        while(count>1&&temp!=null){
            temp=temp.next;
            count--;
        }
        ListNode nextNode=temp.next;
        temp.next=null;
        nodes=reverse(head1);
        ListNode first=nodes[0];
        ListNode last=nodes[1];
        nodes=reverse(nextNode);
        last.next=nodes[0];
        return first;

    }
    ListNode[] reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        ListNode[] nodes=new ListNode[2];
        nodes[0]=prev;
        nodes[1]=head;
        return nodes;
    }
}