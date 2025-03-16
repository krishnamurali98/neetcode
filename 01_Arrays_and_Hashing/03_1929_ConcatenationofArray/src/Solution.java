
import java.util.ArrayList;

public class Solution {
    public int[] getConcatenation_solution1(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int iter=0;iter<2;iter++) {
            for(int x : nums)
                ans.add(x);
        }
        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

    public int[] getConcatenation_solution2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n+n];
        int i=0;
        while(i<n) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
            i++;
        }
        return ans;
    }

    public int[] getConcatenation_solution3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n+n];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }


}
