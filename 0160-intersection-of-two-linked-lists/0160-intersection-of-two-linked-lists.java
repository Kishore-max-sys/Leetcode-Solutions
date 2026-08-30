/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        while(tempA!=null){
            ListNode tempB=headB;
            while(tempB!=null){
                ListNode temp=tempA;
                while(tempB!=null&&tempB!=tempA){
                    tempB=tempB.next;
                }
                if(tempB!=null){
                    ListNode intersect=tempB;
                    while(tempB!=null&&temp!=null&&tempB==temp){
                        tempB=tempB.next;
                        temp=temp.next;
                    }
                    if(tempB==null&&temp==null){
                        return intersect;
                    }
                    tempB=intersect.next;
                }
            } 
            tempA=tempA.next;
        }
        return null;
    }
}