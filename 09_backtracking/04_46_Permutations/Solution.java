class Solution {
    public List<List<Integer>> dfs(int[] nums, int i) {
        if(i >= nums.length) {
            List<List<Integer>> baseCase = new ArrayList<>();
            baseCase.add(new ArrayList<>());
            return baseCase;
        }

        List<List<Integer>> params = dfs(nums, i+1);

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> p : params) {
            for(int j=0;j<=p.size();j++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(j, nums[i]);
                res.add(p_copy);
            }   
        }
        return res;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, 0);
    }
}
