class Solution {
    public void merge(int[] nums, int low, int mid, int high) {
        int n1 = mid-low+1;
        int n2 = high-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++) {
            left[i] = nums[low + i];
        }

        for(int i=0;i<n2;i++) {
            right[i] = nums[mid+1+i];
        }

        int i1=0, i2=0, k = low;
        while(i1 < n1 && i2 < n2) {
            if(left[i1] <= right[i2])
                nums[k++] = left[i1++];
            else
                nums[k++] = right[i2++];
        }

        while(i1 < n1) {
            nums[k++] = left[i1++];
        }

        while(i2 < n2) {
            nums[k++] = right[i2++];
        }
    }

    public void mergeSort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = low + (high-low)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}
