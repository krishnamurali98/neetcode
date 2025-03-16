class Node {
    String val;
    Node next;
    Node prev;
    Node(String val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    Node left, right, curr;
    public BrowserHistory(String homepage) {
        Node homeNode = new Node(homepage);
        left = new Node("");
        right = new Node("");

        left.next = homeNode;
        homeNode.next = right;
        right.prev = homeNode;
        homeNode.prev = left;

       
        curr = homeNode;
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        
        curr.next.prev = null;
        curr.next = null;

        newNode.next = right;
        curr.next = newNode;

        right.prev = newNode;
        newNode.prev = curr;

        curr = newNode;
    }
    
    public String back(int steps) {
        while(curr.prev != left && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(curr.next != right && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
