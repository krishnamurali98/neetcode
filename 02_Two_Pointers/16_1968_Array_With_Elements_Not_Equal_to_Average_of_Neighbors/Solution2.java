class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        for(int i = 1 ; i + 1 < nums.length ; i++) {
            int sum = nums[i-1] + nums[i+1];
            if(nums[i]*2 == sum) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
                if(i > 1) i-=2;
            }
        }
        return nums;
    }
}
