class Solution {
    public boolean isSubsequence_solution1(String s, String t) {
        int i=0, j=0;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }   
        return i >= s.length();
    }

    public boolean isSubsequence_solution2(String s, String t) {
        int i=0, j=0;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        while(i<s1.length && j<t1.length) {
            if(s1[i] == t1[j])
                i++;
            j++;
        }   
        return (i == s.length());
    }


}