class Solution {
    public int[] replaceElements(int[] arr) {
        int currMax = -1;
        int nextMax;
        
        for(int i = arr.length-1;i>=0;i--) {
            nextMax = Math.max(arr[i], currMax);
            arr[i] = currMax;
            currMax = nextMax;
        }   
        return arr;
    }
}