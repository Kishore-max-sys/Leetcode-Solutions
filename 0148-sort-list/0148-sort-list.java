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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);
    }
    ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        ListNode p=left;
        ListNode q=right;
        while(p!=null&&q!=null){
            if(p.val<=q.val){
                temp.next=p;
                p=p.next;
            }else{
                temp.next=q;
                q=q.next;
            }
            temp=temp.next;
        }
        temp.next=(p!=null)?p:q;
        return dummy.next;
    }
}