
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int x : nums ) {
            if(!s.add(x))
                return true;
        }
        
        return false;
    }
}