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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserhead = new ListNode(-1);
        ListNode lessertail = lesserhead;

        ListNode greaterhead = new ListNode(-1);
        ListNode greatertail = greaterhead;

        ListNode temp = head;

        while(temp != null){
            if(temp.val<x){
                 ListNode nodetoInsert = temp;
                 temp = temp.next;
                 nodetoInsert.next = null;
                 //insert at tail -> lessee wali LL me
                lessertail.next = nodetoInsert;
                lessertail = nodetoInsert;
            }else{
                ListNode nodetoInsert = temp;
                 temp = temp.next;
                 nodetoInsert.next = null;
                 //insert at tail -> greater wali LL me
                greatertail.next = nodetoInsert;
                greatertail = nodetoInsert;
            }
        }
        //humari dono list ready h
        //join kro
        lessertail.next = greaterhead.next;
        greatertail.next = null;

        //remove dummy node
        lesserhead = lesserhead.next;

        //return LL
        return lesserhead;
    }
}