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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode prev=odd;
        ListNode connect=head.next;
        ListNode even=head.next;
        while(odd!=null&&even!=null){
            odd.next=even.next;
            prev=odd;
            odd=odd.next;
            if(odd==null) break;
            even.next=odd.next;
            even=even.next;
        }
        if(odd==null){
            prev.next=connect;
        }else{
            odd.next=connect;
        }
        return head;
    }
}