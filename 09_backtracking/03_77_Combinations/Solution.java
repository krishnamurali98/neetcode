class Solution {
    public void dfs(int i, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if(curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(;i<=n;i++) {
            curr.add(i);
            dfs(i+1, n, k, curr, res);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, curr, res);
        return res;
    }
}
