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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prev = head;
        ListNode curr = head;

        // Move curr n steps ahead
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        // If curr becomes null, delete the head
        if (curr == null) {
            return head.next;
        }

        // Move both pointers
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }

        // Delete the required node
        prev.next = prev.next.next;

        return head;
    }
}