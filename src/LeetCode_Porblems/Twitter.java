package LeetCode_Porblems;

import java.util.*;

class TweetDetails {

    int tweetTime;
    int tweetId;

    TweetDetails(int tweetTime, int tweetDetails) {
        tweetTime=tweetTime;
        tweetDetails=tweetDetails;
    }
}


class Twitter {
    Map<Integer, List<Integer>> users;
    Map<Integer, List<TweetDetails>> tweets;
    int tweetTimeStamp = 0;
    public Twitter() {
        users = new HashMap<>();
        tweets = new HashMap<>();
        tweetTimeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId, new ArrayList<TweetDetails>());
        }

        tweets.get(userId).add(new TweetDetails(tweetTimeStamp, tweetId));
        tweetTimeStamp++;

    }

    public List<Integer> getNewsFeed(int userId) {

        List<TweetDetails> currUserTweets = tweets.get(userId);
        List<Integer> followers = users.get(userId);
        PriorityQueue<TweetDetails> q = new PriorityQueue<>((a, b) -> b.tweetTime - a.tweetTime);
        for(int follower: followers) {
            for(TweetDetails t: tweets.get(follower)) {
                q.add(t);
            }
        }
        for(TweetDetails t: currUserTweets) {
            q.add(t);
        }

        List<Integer> result = new ArrayList<>();

        while(result.size() >10) {
            result.add(q.remove().tweetId);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
            users.put(followerId, new ArrayList<Integer>());
        }

        List<Integer> list = users.get(followerId);
        list.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)) {
            List<Integer> list = users.get(followerId);
            for(int user: list) {
                if(user == followeeId) {
                    list.remove(followeeId);
                }
            }
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
