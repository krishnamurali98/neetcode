class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        for (int c : count) {
            if (c > 0)
                pq.add(c);
        }

        while(!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int ele = pq.poll()-1;
                if(ele > 0)
                    queue.add(new int[]{ele, time+n});
            }
            if(!queue.isEmpty() && queue.element()[1] <= time) {
               pq.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
