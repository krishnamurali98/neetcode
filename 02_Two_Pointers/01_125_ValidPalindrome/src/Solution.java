class Solution {
    public boolean isPalindrome_solution1(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character x : s.toCharArray()) {
            if(x >= 'A' && x <= 'Z')
                sb.append(Character.toLowerCase(x));
            if(x >= 'a' && x <= 'z')
                sb.append(x);
            if(x >= '0' && x <= '9')
                sb.append(x);
        } 
        
        int i=0;
        int j = sb.length()-1;
        while(i<j) {
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9');
    }

    public int toLower(char c) {
        if(c >= 'A' && c<='Z') 
            return c+32; 
        return c;
    }


    public boolean isPalindrome_solution2(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(!isAlphaNumeric(start)) {
                i++;
            } else if(!isAlphaNumeric(end)) {
                j--;
            } else if(toLower(start) != toLower(end))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    } 
}