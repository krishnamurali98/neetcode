class Solution {
    public int pivotIndex(int[] nums) {
        int preSum = 0;
        for(int x : nums)
            preSum+=x;

        int left = 0;
        for(int i=0;i<nums.length;i++) {
            int right = preSum-(left+nums[i]);
            if(left == right)
                return i;
            left+=nums[i];
        }
        return -1;
    }
}