
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum_solution1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length<=2) 
            return ans;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++) {
            int j=i+1;
            int k = nums.length-1;
            if(i>0 && nums[i] == nums[i-1])
                continue;
            while(j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0) {
                    ArrayList<Integer> t = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    ans.add(t);
                    while(j+1<k-1 && nums[j] == nums[j+1] && nums[k] == nums[k-1]) {
                        j++;k--;   
                    }
                    j++;
                    k--;
                    

                } else if(sum > 0) 
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_solution2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length<=2) 
            return ans;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++) {
            int j=i+1;
            int k = nums.length-1;
            if(i>0 && nums[i] == nums[i-1])
                continue;
            while(j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1]) j++; 
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                    

                } else if(sum > 0) 
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }



}