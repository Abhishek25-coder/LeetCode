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
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(a == null){
            //ya to b wali list ki len badi h a se ya equal h
            int bExtralen = 0;
            while(b != null){
                bExtralen++;
                b = b.next;
            }
            while(bExtralen-- > 0){
                headB = headB.next;
            }
        }
        else{
            int aExtralen = 0;
            //b == null
            //a wali list length b se ya equal h
            while(a != null){
                aExtralen++;
                a = a.next;
            }
            while(aExtralen-- > 0){
                headA = headA.next; 
            }
        }
        //ab dono list me same no of nodes milenge
        while(headA != null && headB != null){
             if(headA == headB){
                return headA;
             }else{
             headA = headA.next;
             headB = headB.next;
             }
        }
        //koi bhi intersection point nhi mila
        return null;
    }
}