class Solution1 {
    int[] arr;
    public Solution1(int[] nums) {
        arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
