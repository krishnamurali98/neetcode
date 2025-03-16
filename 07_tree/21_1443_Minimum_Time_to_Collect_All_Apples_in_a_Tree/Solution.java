class Solution {
    public int dfs(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int totalTime = 0;
        for(int neighbor : adj.get(node)) {
            if(neighbor == parent)
                continue;
            int subTreeTime = dfs(neighbor, node, adj, hasApple);
            if(subTreeTime > 0 || hasApple.get(neighbor))
                totalTime +=  subTreeTime + 2;
        }
        return totalTime;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] row : edges) {
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        return dfs(0, -1, adj, hasApple);

    }
}
