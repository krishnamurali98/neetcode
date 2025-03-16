
import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for(int i=k-1;i<nums.length;i++) {
            int diff = Math.abs(nums[i]-nums[i-k+1]);
            ans = Math.min(diff, ans);
        }
        return ans;

    }
}