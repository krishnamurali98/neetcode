class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow.next;

        slow.next = null;

        while(curr != null) {
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }

        ListNode x = head;
        ListNode y = prev;
        while(y!= null) {
            ListNode xn = x.next;
            ListNode yn = y.next;
            
            x.next = y;
            y.next = xn;

            x = xn;
            y = yn;
        }
    }
}