class Solution {
    private int maxArray(int[] count) {
        int m = Integer.MIN_VALUE;
        for(int i=0;i<26;i++)
            m = Math.max(m, count[i]);
        return m;
    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int res = 0;
        for(int r = 0;r<s.length();r++) {
            count[s.charAt(r)-'A']++;
            
            while((r-l+1)-maxArray(count) > k) {
                count[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);
                
        }
        return res;
    }

    public int characterReplacement_solution2(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int res = 0;
        int maxCount = 0;
        for(int r = 0;r<s.length();r++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(r)-'A']);
            while((r-l+1)-maxCount > k) {
                count[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);
                
        }
        return res;
    }
}