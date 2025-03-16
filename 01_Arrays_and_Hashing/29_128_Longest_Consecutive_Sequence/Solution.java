class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int num : nums) {
            s.add(num);
        }

        int res = 0;
        for(int num : nums) {
            if(s.contains(num-1)) {
                continue;
            }
            if(s.contains(num)) {
                int curr = 1;
                int currNum = num;
                while(s.contains(currNum+1)) {
                    curr++;
                    currNum++;
                }
                    
                res = Math.max(res, curr);
            }
        }
        return res;
    }
