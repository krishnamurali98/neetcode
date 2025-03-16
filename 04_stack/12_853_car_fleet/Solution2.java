// Solution1 is better

class Solution2 {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[speed.length][2];
        
        for(int i=0;i<speed.length;i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (p1,p2) -> Integer.compare(p1[0], p2[0]));

        int n = arr.length;
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--) {
            int p = arr[i][0];
            int s = arr[i][1];
            double time = (double)(target-p) / s ;
              
            if(!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }

            stack.push(time);
        }
        return stack.size();
    }
}
