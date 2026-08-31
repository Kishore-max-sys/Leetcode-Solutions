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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        while(n>=k){
            int count=k;
            ListNode temp2=temp;
            while(count>1){
                temp2=temp2.next;
                count--;
            }
            ListNode nextNode=temp2.next;
            temp2.next=null;
            ListNode[] nodes=reverse(temp);
            prev.next=nodes[0];
            nodes[1].next=nextNode;
            prev=nodes[1];
            temp=nextNode;
            n-=k;
        }
        return dummy.next;
    }
    ListNode[] reverse(ListNode head){
        ListNode prev=null;
        ListNode temp=head;
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