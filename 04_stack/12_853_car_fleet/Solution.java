class Pair {
    int position;
    int speed;
    Pair(int position, int speed) {
        this.speed = speed;
        this.position = position;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<speed.length;i++) {
            arr.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(arr, (p1,p2) -> Integer.compare(p1.position, p2.position));

        int n = arr.size();
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--) {
            int s = arr.get(i).speed;
            int p = arr.get(i).position;
            double time = (double)(target-p) / s ;
              
            if(!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }

            stack.push(time);
        }
        return stack.size();
    }
