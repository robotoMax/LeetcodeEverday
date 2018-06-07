/**
 * Date: 06/06/2018
 * Created By: Shuai Liu
 * 
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able 
 * to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * 1. postTweet(userId, tweetId): Compose a new tweet.
 * 2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * 3. follow(followerId, followeeId): Follower follows a followee.
 * 4. unfollow(followerId, followeeId): Follower unfollows a followee.
 * 
 * Example:
 * 
 * Twitter twitter = new Twitter();
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
/**
 * Using a technique: Given n sorted linked lists, return a single sorted lists
 */
import java.util.*;
public class DesignTwitter {

    private static int TIMESTAMP = 0;
    Map<Integer, User> userMap;

    private class Tweet {
        int tid;
        Tweet next;
        int time;
        public Tweet(int tid) {
            this.tid = tid;
            this.time = TIMESTAMP++;
            this.next = null;
        }
    }

    private class User {
        int uid;
        Tweet t_head;
        Set<Integer> followed;
        public User(int uid) {
            this.uid = uid;
            t_head = null;
            followed = new HashSet<>();
            followed.add(this.uid);
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = t_head;
            t_head = t;
        }

    }

    /** Initialize your data structure here. */
    public DesignTwitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> heap = new PriorityQueue<>(users.size(), (a, b) -> b.time - a.time);
        for (int uid : users) {
            Tweet t = userMap.get(uid).t_head;
            if (t != null) heap.add(t);
        }
        while (!heap.isEmpty() && res.size() < 10) {
            Tweet t = heap.poll();
            res.add(t.tid);
            if (t.next != null) heap.add(t.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}