
import java.util.HashMap;

public class Solution {
    public boolean isAnagram_solution1(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> h1 = new HashMap<>();
        
        for(char x : s.toCharArray())
            h1.put(x, h1.getOrDefault(x, 0)+1);

        for(char x : t.toCharArray()) 
            h1.put(x, h1.getOrDefault(x, 0) - 1);

        for(int count : h1.values()) {
            if(count != 0)
                return false;
        }
        return true;   
    }

    public boolean isAnagram_solution2(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] freq = new int[256];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }

        for(int x : freq)
            if(x != 0)
                return false;
        return true;
    }

    public boolean isAnagram_solution3(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] freq = new int[256];
        for(char x : s.toCharArray())
            freq[x]++;
        for(char x : t.toCharArray())
            freq[x]--;

        for(int x : freq)
            if(x != 0)
                return false;
        return true;

            
    }
    
    public static void main(String[] args) {
        
    }    
}
