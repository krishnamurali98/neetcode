class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode slow_p = null;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow_p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }     

        slow_p.next = null;

        ListNode prev = null;
        ListNode curr = slow;
        
        while(curr!=null) {
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }

        int ans = Integer.MIN_VALUE;
        
        while(head != null && prev != null) {
            ans = Math.max(ans, head.val+prev.val);
            head = head.next;
            prev = prev.next;
        }

        return ans;

    }
}