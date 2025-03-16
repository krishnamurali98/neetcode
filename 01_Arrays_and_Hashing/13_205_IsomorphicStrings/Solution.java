
import java.util.Arrays;

class Solution {
    public boolean isIsomorphic_solution1(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        Arrays.fill(mapS, -1);
        Arrays.fill(mapT, -1);
        for(int i=0;i<s.length();i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(mapS[charS] == -1) {
                mapS[charS] = charT;
            } else if(mapS[charS] != charT)
                return false;
           
            if(mapT[charT] == -1) {
                mapT[charT] = charS;
            } else if(mapT[charT] != charS)
                return false;
        }

        return true;
    }


    public boolean isIsomorphic_solution2(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        if (s.length() != t.length()) {
            return false;
        }
        
        for(int i=0;i<s.length();i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(mapS[charS] == 0 && mapT[charT] == 0) {
                mapS[charS] = charT;
                mapT[charT] = charS;
            } else if(mapS[charS] != charT || mapT[charT] != charS)
                return false;
        }

        return true;
    }
}