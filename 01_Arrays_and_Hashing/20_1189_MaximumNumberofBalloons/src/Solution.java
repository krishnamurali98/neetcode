class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[256];

        for(char x : text.toCharArray()) {
                count[x]++;    
        }
        int minCount = Math.min(count['b'], 
                        Math.min(count['a'], 
                        Math.min(count['n'], 
                        Math.min(count['l'] / 2, count['o'] / 2))));

        return minCount;
        
    }
}