import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            boolean isShown = false;
            int nextGreater = -1;
            for(int j=0;j<nums2.length;j++) {
                if(isShown && nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }

                if(nums2[j] == nums1[i]) {
                    isShown = true;
                }   
            }
            ans[i] = nextGreater;
        }
        return ans;
    }

    public int[] nextGreaterElement_solution2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int n = nums2.length;
        
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(nums2[n-1], -1);

        Stack<Integer> s = new Stack<>();
        s.push(nums2[n-1]);
        for(int i=n-2;i>=0;i--) {
            while(!s.isEmpty() && s.peek() < nums2[i])
                s.pop();
            if(!s.isEmpty())
                m.put(nums2[i], s.peek());
            else
                m.put(nums2[i], -1);
            s.push(nums2[i]);
        }

        int i = 0;
        for(int x : nums1) {
            ans[i] = m.get(x);
            i++;
        }
        return ans;

    }

}