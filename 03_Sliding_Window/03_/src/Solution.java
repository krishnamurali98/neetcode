class Solution {
    public int numOfSubarrays_solution1(int[] arr, int k, int threshold) {
        int sum = 0;
        int res = 0;

        for(int i=0;i<k;i++)
            sum+=arr[i];
        
        int avg = (int)sum/k;
        if(avg>=threshold)
            res++;

        for(int i=k;i<arr.length;i++) {
            sum = sum-arr[i-k]+arr[i];
            avg = (int)sum/k;
            if(avg >= threshold)
                res++;
        }
        return res;
    }


    public int numOfSubarrays_solution2(int[] arr, int k, int threshold) {
        int sum = 0;
        int res = 0;
        int targetSum = k*threshold;

        for(int i=0;i<k;i++)
            sum+=arr[i];
        
        if(sum>=targetSum)
            res++;

        for(int i=k;i<arr.length;i++) {
            sum = sum-arr[i-k]+arr[i];
            if(sum>=targetSum)
                res++;
        }
        return res;
    }

}