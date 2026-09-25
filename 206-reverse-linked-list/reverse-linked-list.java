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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode forward = curr.next;
            //traverse kro prev or curr ko aage badhao
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        //head ko update krdo
        return prev;
    }
}