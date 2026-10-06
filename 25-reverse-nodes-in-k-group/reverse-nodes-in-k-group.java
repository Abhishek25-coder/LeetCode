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
    public ListNode reverseKGroup(ListNode head, int k) {
        
  int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        if(len < k){
            return head;
        }
        //first k-len group ko reverse kro
        ListNode prev = null;
        ListNode curr = head;

        for(int i=1;i<=k;i++){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        //remaining list ko recursion se solve krlo
        ListNode recursionKans = reverseKGroup(curr,k);
        //join both LL
        head.next = recursionKans;
        //return 
        return prev;
    }
}