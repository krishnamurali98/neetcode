import java.util.ArrayDeque;

class Solution {
    public char getMatch(char c) {
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> '\0';
        };
    }


    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if(t == '(' || t == '{' || t == '[')
                st.push(t);
            else {
                
                if(!st.isEmpty() && getMatch(t) == st.peek())
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}