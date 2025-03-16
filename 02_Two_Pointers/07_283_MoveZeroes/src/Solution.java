class Solution {
    public void moveZeroes_solution1(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            if(nums[right] != 0) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
            }
            right++;
        
        }   
    }

    public void moveZeroes_solution2(int[] nums) {
        int left = 0;
        for(int right = 0;right < nums.length;right++) {
            if(nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }

        for(;left < nums.length;left++) {
            nums[left] = 0;
        }
    }
}