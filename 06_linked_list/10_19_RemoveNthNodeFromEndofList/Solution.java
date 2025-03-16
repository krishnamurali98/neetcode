class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode removeNthFromEnd_solution1(ListNode head, int n) {
        if(head == null || n < 0)
            return head;
        
        ListNode p1_prev = null;
        ListNode p1 = head;
        ListNode p2 = head;

        while(p2 != null) {
            if(n > 0) 
                n--;
            else {
                p1_prev = p1;
                p1 = p1.next;
            }
                
            p2 = p2.next;
        }

        if(n > 0)
            return head;
        if(p1 == head)
            head = head.next;
        else
            p1_prev.next = p1_prev.next.next;
        return head;
    }

    public ListNode removeNthFromEnd_solution2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        for(int i=0;i<=n;i++) {
            if(p2 == null)
                return head;
            p2 = p2.next;
        }

        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return dummy.next;
    }
 
}