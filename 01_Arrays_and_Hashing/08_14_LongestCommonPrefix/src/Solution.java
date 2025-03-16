class Solution {
    public String longestCommonPrefix_solution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0;i<strs[0].length();i++) {
            for(String s : strs) {
                if(i == s.length() || strs[0].charAt(i) != s.charAt(i))
                    return res.toString();
            }
            res.append(strs[0].charAt(i));
        }      
        return res.toString();
    }

    public String longestCommonPrefix_solution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the initial prefix
        String prefix = strs[0];
        
        // Compare the prefix with each subsequent string
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the current prefix, shorten the prefix
            while (strs[i].indexOf(prefix) != 0) {
                System.out.println(i + " " + strs[i].indexOf(prefix) + " " + prefix);
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, return empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        // Return the longest common prefix
        return prefix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs= {"flower", "flow", "flight"};
        System.out.println(s.longestCommonPrefix_solution2(strs));
    }
    
}