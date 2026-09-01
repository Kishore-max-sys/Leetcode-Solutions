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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        int rem=len-n;
        temp=head;
        ListNode prev=null;
        while(rem>0&&temp!=null){
            prev=temp;
            temp=temp.next;
            rem--;
        }
        if(prev==null){
            temp=head;
            head=head.next;
            temp.next=null;
            return head;
        }
        prev.next=temp.next;
        temp.next=null;
        return head;
    }
}