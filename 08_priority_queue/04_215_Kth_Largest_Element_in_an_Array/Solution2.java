// TLE but good to know
class Solution {
    private int partition(int[] nums, int low, int high) {
        int index = (int) (Math.random() * (high - low + 1)) + low;
        int pivotPoint = nums[index];

        nums[index] = nums[high];
        nums[high] = pivotPoint;
        
        int i = low; 
        for(int j=low;j<high;j++) {
            if(nums[j] <= pivotPoint) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; 
            }
        }
        nums[high] = nums[i];
        nums[i] = pivotPoint;

        return i;
    }

    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;


        int targetIndex = nums.length-k;


        while(low <= high) {
            int pivot = partition(nums, low, high);
            if(pivot == targetIndex)
                return nums[pivot];
            else if(pivot < targetIndex) 
                low = pivot+1;
            else
                high = pivot-1;
        }
        return -1;
    }
}
