class Solution {
    public void dfs(int i, int[] candidates, List<Integer> curr, int total, List<List<Integer>> res, int target) {
        if(total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i>=candidates.length || total > target)
            return;
        
        curr.add(candidates[i]);
        dfs(i, candidates, curr, total+candidates[i], res, target);
        curr.remove(curr.size()-1);
    
    
        dfs(i+1, candidates, curr, total, res, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0, candidates, curr, 0, res, target);
        return res;
    }
}
