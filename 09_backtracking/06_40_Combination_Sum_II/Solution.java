class Solution {
    public void dfs(int[] candidates, int i, int currTotal, List<Integer> curr, List<List<Integer>> res, int target) {
        if(currTotal == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= candidates.length || currTotal > target)
            return;

        curr.add(candidates[i]);
        dfs(candidates, i+1, currTotal+candidates[i], curr, res, target);
        curr.remove(curr.size()-1);

        for(;i+1 < candidates.length && candidates[i] == candidates[i+1];i++);
        dfs(candidates, i+1, currTotal, curr, res, target);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, 0, 0, curr, res, target);
        return res;
    }
}
