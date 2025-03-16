
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> threeSum(int[] nums, int target, int first) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=first;i<nums.length;i++) {
            int j = i+1;
            int k = nums.length-1;
            if(i > first && nums[i] == nums[i-1]) continue;
            while(j < k) {
                long sum = (long)nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if(sum > target)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    } 

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fin = new ArrayList<>();
        Arrays.sort(nums);
        for(int first=0;first<nums.length;first++) {
            if(first>0 && nums[first] == nums[first-1]) continue;
            List<List<Integer>> ans = threeSum(nums, target-nums[first], first+1);
            for(List<Integer> x : ans) {
                List<Integer> quad = new ArrayList<>(x);
                quad.add(0, nums[first]);
                fin.add(quad);
            }
        }
        return fin;
    }
}