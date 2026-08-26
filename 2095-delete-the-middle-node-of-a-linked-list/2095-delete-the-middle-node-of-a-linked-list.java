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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        ListNode temp1=head;
        ListNode prev=temp1;
        ListNode temp2=head;
        while(temp2!=null && temp2.next!=null){
            prev=temp1;
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        prev.next=temp1.next;
        return head;
    }
}