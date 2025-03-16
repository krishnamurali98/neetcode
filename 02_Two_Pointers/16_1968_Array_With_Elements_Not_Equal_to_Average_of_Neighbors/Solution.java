class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Arrays.sort(nums);

        int mid = (n-1)/2;
        
        int start = 0;
        int end = mid+1;

        int index = 0;
        while(index < n) {
            if(start <= mid)
                res[index++] = nums[start++];
            if(end < n)
                res[index++] = nums[end++];   
        }
        return res;
    }
}
