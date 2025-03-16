class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;
        for(int i=0;i<k;i++) {
            if(temp == null)
                return head;
            temp = temp.next;
        }
        ListNode p1 = temp;
        
        ListNode p2 = dummy;
        while(temp != null) {
            p2 = p2.next;
            temp = temp.next;
        }

        int s = p1.val;
        p1.val = p2.val;
        p2.val = s;
        return dummy.next;
    }
}