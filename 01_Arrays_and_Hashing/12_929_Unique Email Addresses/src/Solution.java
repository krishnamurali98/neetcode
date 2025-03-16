
import java.util.HashSet;

class Solution {
    public int numUniqueEmails_solution1(String[] emails) {
        HashSet<String> s = new HashSet<>();
        for(String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            if(local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replace(".", "");
            String clean = local+"@"+domain;
            s.add(clean);
        }
        return s.size();
    }

    public String filter(String name) {
        StringBuilder sb = new StringBuilder();
        boolean isDomain = false;
        for(int i=0;i<name.length();i++) {
            if(!isDomain && name.charAt(i) == '+') {
                while(name.charAt(i+1)!='@')
                    i++;
            } else if(isDomain || name.charAt(i) != '.') {
                if(name.charAt(i) == '@')
                    isDomain = true;
                sb.append(name.charAt(i));
            }
        }
        return sb.toString();
    }
    public int numUniqueEmails_solution2(String[] emails) {
        HashSet<String> s = new HashSet<>();
        for(String email : emails) {
            s.add(filter(email));
        }        
        return s.size();
    }
}