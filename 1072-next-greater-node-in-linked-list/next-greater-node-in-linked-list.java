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
    public int[] nextLargerNodes(ListNode head) {
        //linked list ko array me convert krna h
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        //main logic
        int n = list.size();
        int[] ans = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() &&  list.get(i) > list.get(st.peek())){
                int previousNode = st.pop();
                ans[previousNode] =  list.get(i);
            }
            //current element ko stack me push krna h
            st.push(i);
        }
        return ans;
    }
}