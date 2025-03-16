class Solution {
    public int lengthOfLastWord(String s) {
        char[] s1 = s.toCharArray();
        int count=0;
        for(int i=s1.length-1;i>=0;i--) {
            if(s1[i] == ' ')
                continue;
            count++;
            if(i-1 <= -1 || s1[i-1] == ' ')
                break;
        }
        return count;
    }
}