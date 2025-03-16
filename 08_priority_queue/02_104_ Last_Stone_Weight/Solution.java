class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones) {
            pq.add(num);
        }

        while(!pq.isEmpty() && pq.size() > 1) {
            int p1 = pq.poll();
            int p2 = pq.poll();
            if(p1 != p2)
                pq.add(p1-p2);
        }
        return pq.isEmpty() ? 0 : pq.peek();

    }
}
