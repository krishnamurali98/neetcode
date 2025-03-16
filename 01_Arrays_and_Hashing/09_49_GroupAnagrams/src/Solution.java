
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams_solution1(String[] strs) {
        HashMap<String, ArrayList<String>> h = new HashMap<>();
        for(String s : strs) {
            int[] count = new int[256];
            for(char c : s.toCharArray())
                count[c]++;
            String t = Arrays.toString(count);
            if(!h.containsKey(t))
                h.put(t, new ArrayList<>());
            h.get(t).add(s);
        }
        return new ArrayList<>(h.values());
    }

    public List<List<String>> groupAnagrams_solution2(String[] strs) {
        HashMap<String, ArrayList<String>> h = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String t = new String(c);
            if (!h.containsKey(t))
                h.put(t, new ArrayList<>());
            h.get(t).add(s);
        }
        return new ArrayList<>(h.values());
    }


}