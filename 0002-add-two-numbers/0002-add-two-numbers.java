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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode p1=temp1;
        ListNode p2=temp2;
        while(temp1!=null&&temp2!=null){
            p1=temp1;
            temp1=temp1.next;
            p2=temp2;
            temp2=temp2.next;
        }
        while(temp1!=null){
            ListNode newNode=new ListNode(0);
            p2.next=newNode;
            p2=p2.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            ListNode newNode=new ListNode(0);
            p1.next=newNode;
            p1=p1.next;
            temp2=temp2.next;
        }
        temp1=l1;
        temp2=l2;
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        int carry=0;
        while(temp1!=null&&temp2!=null){
            int sum=temp1.val+temp2.val+carry;
            ListNode newNode=new ListNode(sum%10);
            temp.next=newNode;
            temp=temp.next;
            carry=sum/10;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(carry>0){
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;
        }
        return dummy.next;
    }
}