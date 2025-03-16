class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    Node left, right;
    public MyLinkedList() {
        left = new Node(-1);
        right = new Node(-1);

        left.next = right;
        right.prev = left;
    }

    public int get(int index) {
        Node curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (index == 0 && curr != null && curr != right)
            return curr.value;
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node p = left;
        Node n = left.next;

        newNode.next = n;
        p.next = newNode;

        newNode.prev = p;
        n.prev = newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node p = right.prev;
        Node n = right;

        newNode.next = n;
        p.next = newNode;

        newNode.prev = p;
        n.prev = newNode;
    }

    public void addAtIndex(int index, int val) {
        Node curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (curr != null && index == 0) {
            Node newNode = new Node(val);
            Node p = curr.prev;
            Node n = curr;

            newNode.next = n;
            p.next = newNode;

            newNode.prev = p;
            n.prev = newNode;
        }

    }

    public void deleteAtIndex(int index) {
        Node curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (curr != null && index == 0 && curr != right) {
            Node p = curr.prev;
            Node n = curr.next;

            p.next = n;
            n.prev = p;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
