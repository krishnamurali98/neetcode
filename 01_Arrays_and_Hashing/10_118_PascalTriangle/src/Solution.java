
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1)
            return ans;
            
        
        ans.add(new ArrayList<>(Arrays.asList(1,1)));
        if(numRows == 2)
            return ans;
    
        for(int i=2;i<numRows;i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1;j<ans.get(i-1).size();j++) {
                curr.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}