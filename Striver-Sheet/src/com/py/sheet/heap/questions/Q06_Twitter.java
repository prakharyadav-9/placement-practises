
import java.util.*;

public class Q06_Twitter {
    class Twitter {

     class twitterUser{
        int userId,tweet;
        public twitterUser(int user,int tweet){
            this.userId=user;
            this.tweet=tweet;
        }
    }
ArrayList<twitterUser>allUser;
HashMap<Integer,HashSet<Integer>>userMap;
    Twitter(){
        allUser=new ArrayList<>();
        userMap=new HashMap<>();
    }
void postTweet(int userId, int tweetId) {
    allUser.add(new twitterUser(userId, tweetId));
}

// Retrieve the 10 most recent tweet ids as mentioned in question
List<Integer> getNewsFeed(int userId) {
    List<Integer>recentNews=new ArrayList<>();
     HashSet<Integer>friendlist=userMap.get(userId);
     int newsCount=0;
   //  System.out.println(friendlist);
     for (int i = allUser.size()-1; i>=0; i--) {
        twitterUser user=allUser.get(i);
        if(user==null)continue;
        if(newsCount<10&&(user.userId==userId||(friendlist!=null?friendlist.contains(user.userId):false))){
            newsCount++;
            recentNews.add(user.tweet);
        }
     }
    return recentNews;
}
void follow(int userId, int friendId) {
    if(!userMap.containsKey(userId)){
        //create friend list
        userMap.put(userId, new HashSet<>());
   
        
    }
    //follow friend
    userMap.get(userId).add(friendId);
}
void unfollow(int userId, int friendId) {
    if(userMap.containsKey(userId)){
        //unfollow friend from friendlist
        userMap.get(userId).remove(friendId);}
}
}
}
