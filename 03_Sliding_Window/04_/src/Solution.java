
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring_solution1(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int j=0;
        for(int i=0;i<s.length();i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++; 
            }
                
    
            set.add(s.charAt(i));
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    public int lengthOfLongestSubstring_solution2(String s) {
        boolean[] visited = new boolean[256];
        int ans = 0;
        int j=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            while(visited[c]) {
                visited[s.charAt(j)] = false;
                j++; 
            }

            visited[c] = true;
            ans = Math.max(ans, i-j+1);
        }
        return ans;
    }
}