class Solution {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> s = new ArrayDeque<>();
        
        for(char c : num.toCharArray()) {
            while(!s.isEmpty() && c < s.peek() && k > 0) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        while(k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()) {
            ans.append(s.pop());
        }
        ans.reverse();
        while(ans.length() > 1 && ans.charAt(0) == '0')
            ans.deleteCharAt(0);

        return ans.length() == 0 ? "0" : ans.toString();
    } 
}
