class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode p = null;
        ListNode c = slow;
        while(c != null) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        while(p != null) {
            if(p.val != head.val)
                return false;
            head = head.next;
            p = p.next;
        }
        return true;
    }
}