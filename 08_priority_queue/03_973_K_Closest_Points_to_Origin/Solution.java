class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        
        for(int i=0;i<points.length;i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int z = x*x + y*y;
            
            pq.add(new int[]{i, z});
        }


        int ans_index = 0;
        for(int i=0;i<k;i++) {
            int[] arr = pq.poll();
            int index = arr[0];
            ans[ans_index][0] = points[index][0];
            ans[ans_index][1] = points[index][1];
            ans_index++;
        }
        
        return ans;
    }
}
