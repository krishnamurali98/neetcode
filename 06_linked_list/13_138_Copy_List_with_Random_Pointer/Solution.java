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
        if(head == null)
            return null;

        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        while(curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;

        while(original != null) {
            original.next = original.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            
            copy = copy.next;
            original = original.next;
        }
        return copyHead;
    }
}
