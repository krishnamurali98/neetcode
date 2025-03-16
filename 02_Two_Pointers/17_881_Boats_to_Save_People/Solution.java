class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int boats = 0;
        
        int start = 0;
        int end = people.length-1;
        while(start <= end) {
            int sum = people[start] + people[end];
            if(sum <= limit)
                start++;
            end--;
            boats++;
        }
        return boats;
    }
