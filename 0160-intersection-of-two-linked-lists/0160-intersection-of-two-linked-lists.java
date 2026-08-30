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
            while(tempB!=null&&tempB!=tempA){
                tempB=tempB.next;
            }
            if(tempB!=null) return tempB;
            tempA=tempA.next;
        }
        return null;
    }
}
