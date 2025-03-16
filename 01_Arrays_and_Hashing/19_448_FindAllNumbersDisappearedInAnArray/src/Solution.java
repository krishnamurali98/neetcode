
import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // requirements match with the question
    public List<Integer> findDisappearedNumbers_solution1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] = -nums[index];
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) 
                ans.add(i+1);
        }
        return ans;

    }

    // extra array is used
    public List<Integer> findDisappearedNumbers_solution2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[nums.length+1];
        for(int i=0;i<nums.length;i++) {
            visited[nums[i]] = 1;
        }

        for(int i=1;i<visited.length;i++) {
            if(visited[i] == 0)
                ans.add(i);
        }
        return ans;
    }


}