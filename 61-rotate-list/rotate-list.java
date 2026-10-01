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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        //list ko circular bnao aur LL ki length find kro
        int len =1;
        ListNode temp = head;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        //make it circular
        temp.next = head;

        //k ko update krdo
        k = k % len;

        // link break kro aur forward set kro
        temp = head;
        for(int i=1;i<len-k;i++){
            temp = temp.next;
        }
        ListNode forward = temp.next;
        //link break
        temp.next = null;

        //return forward
        return forward;
    }
}