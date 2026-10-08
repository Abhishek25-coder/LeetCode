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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null){
            return new int[]{-1,-1};
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int i =1;
        List<Integer> criticalpoint = new ArrayList<>();

        while(curr != null && curr.next != null){
            //compare for local maxima
            if(curr.val > prev.val && curr.val > curr.next.val){
                criticalpoint.add(i);
            }
            //compare for local minima
            if(curr.val < prev.val && curr.val < curr.next.val){
                criticalpoint.add(i);
            }
            prev = prev.next;
            curr = curr.next;
            i = i+1;
        }
        if(criticalpoint.size() < 2){
            return new int[]{-1,-1};
        }
        //min or max find krna h
        int mindist = Integer.MAX_VALUE;
        for(int j =1; j< criticalpoint.size(); j++){
        mindist = Math.min(mindist, criticalpoint.get(j) - criticalpoint.get(j-1)); 
        }
        int maxdist = criticalpoint.get(criticalpoint.size()-1) - criticalpoint.get(0); 
        return new int[]{mindist,maxdist};
    }
}