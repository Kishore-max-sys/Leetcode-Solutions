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
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null&&temp!=head2){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        ListNode tail1=prev;
        if(fast!=null) head2=head2.next;
        while(tail1!=null&&head2!=null){
            if(tail1.val!=head2.val){
                return false;
            }
            tail1=tail1.next;
            head2=head2.next;
        }
        return true;
    }
}
