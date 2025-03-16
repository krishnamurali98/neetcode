class Solution {
    public int dfs(int node, int parent, List<Integer>[] adj, List<Boolean> hasApple) {
        int totalTime = 0;
        for(int neighbor : adj[node]) {
            if(neighbor == parent)
                continue;
            int subTreeTime = dfs(neighbor, node, adj, hasApple);
            if(subTreeTime > 0 || hasApple.get(neighbor))
                totalTime +=  subTreeTime + 2;
        }
        return totalTime;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] row : edges) {
            adj[row[0]].add(row[1]);
            adj[row[1]].add(row[0]);
        }
        return dfs(0, -1, adj, hasApple);

    }
}
