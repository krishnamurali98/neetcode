class Solution {
    public int maxArea_solution1(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(i<j) {
            int w = j-i;
            int h = Math.min(height[i], height[j]);
            int curr = w*h;
            maxArea = Math.max(maxArea, curr);
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

    public int maxArea_solution2(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(i<j) {
            int w = j-i;
            int h = Math.min(height[i], height[j]);
            int curr = w*h;
            maxArea = Math.max(maxArea, curr);
            while (i < j && height[i] <= h) {
                i++;
            } 
            while (i < j && height[j] <= h) {
                j--;
            }
        }
        return maxArea;
    }
}