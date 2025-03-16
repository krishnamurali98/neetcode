
import java.util.HashMap;

class Solution {
    public boolean wordPattern_solution1(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;

        HashMap<Character, String> m1 = new HashMap<>();
        HashMap<String, Character> m2 = new HashMap<>();

        for(int i=0;i<pattern.length();i++) {
            char p = pattern.charAt(i);
            String w = words[i];
            if(m1.containsKey(p)) {
                if(!m1.get(p).equals(w))
                    return false;
            }else
                m1.put(p, w);
        
            if(m2.containsKey(w)) {
                if(!m2.get(w).equals(p))
                    return false;
            } else
                m2.put(w, p);
        }
        return true;

    }

    public boolean wordPattern_solution2(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;

        HashMap<Character, String> m1 = new HashMap<>();
        HashMap<String, Character> m2 = new HashMap<>();

        for(int i=0;i<pattern.length();i++) {
            char p = pattern.charAt(i);
            String w = words[i];
            if(!m1.containsKey(p) && !m2.containsKey(w)) {
                m1.put(p, w);
                m2.put(w, p);   
            } else if(m1.get(p) == null || m2.get(w) == null) {
                return false;
            } else if(!m1.get(p).equals(w) || !m2.get(w).equals(p)) {
                return false;
            }
        
                
        }
        return true;

    }
}
