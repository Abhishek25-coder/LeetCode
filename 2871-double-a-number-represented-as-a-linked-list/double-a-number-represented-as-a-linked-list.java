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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        //step 1: reverse LL
        head = reverse(head);
        //step 2: do maths 
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode temp = head;
        int carry = 0;
        while(temp!= null){
            int value = temp.val;
            int sum = value + value + carry;
            int digit = sum%10;
            //add this node to dummy LL
            curr.next = new ListNode(digit);
            curr = curr.next;
            //check carry
            carry = sum/10;
            temp = temp.next;
        }
        //extra condition
        if(temp == null && carry != 0){
            curr.next = new ListNode(carry);
        }
        //remove dummy LL
        dummy = dummy.next;
        //reverse again
        head = reverse(dummy);
        return head;
    }
}