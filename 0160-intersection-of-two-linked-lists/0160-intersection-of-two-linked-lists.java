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
        int n1=0;
        ListNode tempA=headA;
        while(tempA!=null){
            n1++;
            tempA=tempA.next;
        }
        int n2=0;
        ListNode tempB=headB;
        while(tempB!=null){
            n2++;
            tempB=tempB.next;
        }
        if(n1>n2) return getIntersectionNode(headB,headA);
        tempA=headA;
        tempB=headB;
        while(n2>=n1&&tempB!=null){
            if(tempA==tempB) return tempA;
            tempB=tempB.next;
            n2--;
        }
        tempA=tempA.next;
        while(tempA!=null&&tempB!=null){
            if(tempA==tempB) return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}