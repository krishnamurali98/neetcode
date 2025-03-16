
import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    public int calPoints_soln1(String[] operations) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(String x : operations) {
            switch (x) {
                case "+" -> {
                    int top = s.pop();
                    int c = top+s.peek();
                    s.push(top);
                    s.push(c);
                }
                case "D" -> s.push(s.peek()*2);
                case "C" -> s.pop();
                default -> s.push(Integer.valueOf(x));
            }
            
        }

        int ans = 0;
        for(int x : s) {
            ans+=x;
        }
        return ans;   
    }

    public int calPoints_soln2(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(String x : operations) {
            switch (x) {
                case "+" -> {
                    int top = s.pop();
                    int c = top+s.peek();
                    s.push(top);
                    s.push(c);
                }
                case "D" -> s.push(s.peek()*2);
                case "C" -> s.pop();
                default -> s.push(Integer.valueOf(x));
            }
            
        }

        int ans = 0;
        for(int x : s) {
            ans+=x;
        }
        return ans;   
    }
}