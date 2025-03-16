class Twitter {
    private int count;
    private HashMap<Integer, ArrayList<int[]>> tweetMap;
    private HashMap<Integer, HashSet<Integer>> followMap;

    public Twitter() {
        this.count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        
        
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[] { this.count, tweetId });
        this.count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        
        if(followMap.get(userId) == null) {
            followMap.put(userId, new HashSet<>());
        }
        followMap.get(userId).add(userId);



        for(int followeeId : followMap.get(userId)) {
            if(tweetMap.containsKey(followeeId)) {
                ArrayList<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size()-1;

                int[] lastTweet = tweets.get(index);
                pq.add(new int[]{lastTweet[0], lastTweet[1], followeeId, index-1});
            }   
        }


        while(!pq.isEmpty() && ans.size() < 10) {
            int[] top = pq.poll(); // count, tweetId, followeeId, index
            int tweetId = top[1];
            int followeeId = top[2];
            int nextIndex = top[3];
            
            ans.add(tweetId);
            
            if(nextIndex >= 0) {
                int[] nextTweet = tweetMap.get(followeeId).get(nextIndex);
                pq.add(new int[]{nextTweet[0], nextTweet[1], followeeId, nextIndex-1});
            }
            
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followMap.get(followerId) == null) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
