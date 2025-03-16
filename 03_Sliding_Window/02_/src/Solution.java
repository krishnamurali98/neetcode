
import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(s.size() == k+1) {
                s.remove(nums[i-k-1]);
            }
            if(s.contains(nums[i]))
                return true;
            s.add(nums[i]);
        }   
        return false; 
    }
}