public class Solution {
    public ListNode getIntersectionNode_solution1(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        int countA = 0;
        while(curr1 != null) {
            countA++;
            curr1 = curr1.next;
        }
        
        ListNode curr2 = headB;
        int countB = 0;
        while(curr2 != null) {
            countB++;
            curr2 = curr2.next;
        }

        int r = Math.abs(countA-countB);
        if(countA > countB) {
            while(headA != null && r>0) {
                headA = headA.next;
                r--;
            }
        } else {
            while(headB != null && r>0) {
                headB = headB.next;
                r--;
            }
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;

    }

    public ListNode getIntersectionNode_solution2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;

    }

}