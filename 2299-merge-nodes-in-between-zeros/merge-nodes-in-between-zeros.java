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
    public ListNode mergeNodes(ListNode head) {
        ListNode write = head;
        ListNode read = head.next;

        while(read != null){
            int sum = 0;
            while(read.val != 0){
                sum = sum + read.val;
                read = read.next;
            }
            //insert sum ki value ko write wali position par
            write.val = sum;

            //delete faltu ke nodes
            write.next = read.next;

            //read and write ko 1 step forward krdo
            read = read.next;
            write = write.next;
        }
        return head;
    }
}