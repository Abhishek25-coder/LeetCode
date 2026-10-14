/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //clone nodes add
        Node temp = head;
        while(temp != null){
            Node cloneNode = new Node(temp.val);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }
        //copy random pointers
         temp = head;
        while(temp != null){
            Node oldNode = temp;
            Node newNode = temp.next;
            //observation -> newnode ka random = oldnode ke random ka next
            if(oldNode.random != null){
                newNode.random = oldNode.random.next;
            }
            //tep ko move kro
            temp = newNode.next;
        }
        //detach the list
        temp = head;
        Node ansListHead = head.next;

        while(temp != null){
            Node oldNode = temp;
            Node newNode = temp.next;
            //detach ka logic
            oldNode.next = newNode.next;
            if(newNode.next != null){
                 newNode.next = newNode.next.next;
            }
            temp = oldNode.next;
        }
        return ansListHead;
    }
}