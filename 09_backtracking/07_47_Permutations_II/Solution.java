class Solution {
    public void dfs(int n, HashMap<Integer, Integer> hm, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > 0) {
                curr.add(key);
                hm.put(key, value-1);

                dfs(n, hm, curr, res);

                hm.put(key, value);
                curr.remove(curr.size()-1);
            }
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        dfs(nums.length, hm, curr, res);
        
        return res;
    }
}
