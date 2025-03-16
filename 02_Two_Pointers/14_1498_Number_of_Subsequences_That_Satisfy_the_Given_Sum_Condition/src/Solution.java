
import java.util.Arrays;

class Solution {
    public int numSubseq_solution1(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;

        int mod = 1000000007;
        int res = 0;
        
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int k = 1; k < nums.length; k++) {
            power[k] = (power[k - 1] * 2) % mod;
        }

        while(i <= j) {
            while(i<=j && nums[i] + nums[j] > target)
                j--;
            if(i<=j) {
                res = (res + power[j - i]) % mod;
            }
            i++;
        }    
        return res;
    }
    public int numSubseq_solution2(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;

        int mod = 1000000007;
        int res = 0;
        
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int k = 1; k < nums.length; k++) {
            power[k] = (power[k - 1] * 2) % mod;
        }

        while(i <= j) {
            if(nums[i] + nums[j] <= target) {
                res = (res + power[j - i]) % mod;
                i++;
            } else
                j--;
        }    
        return res;
    }
}