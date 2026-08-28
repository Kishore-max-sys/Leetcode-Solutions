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
    public boolean isPalindrome(ListNode head) {
        ListNode head2=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            head2=head2.next;
            fast=fast.next.next;
        }
        if(fast!=null) head2=head2.next;
        ListNode prev=null;
        while(head2!=null){
            ListNode next=head2.next;
            head2.next=prev;
            prev=head2;
            head2=next;
        }
        ListNode head1=head;
        head2=prev;
        while(head1!=null&&head2!=null){
            if(head1.val!=head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }
}