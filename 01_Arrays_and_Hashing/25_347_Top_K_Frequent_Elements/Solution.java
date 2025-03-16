class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        HashMap<Integer, Integer> hm = new HashMap<>();

        ArrayList<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            freq[value].add(key);
        }

        int index = 0;
        for (int i = nums.length; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                if(index < k)
                    ans[index++] = num;
            }
        }
        return ans;
    }
}
