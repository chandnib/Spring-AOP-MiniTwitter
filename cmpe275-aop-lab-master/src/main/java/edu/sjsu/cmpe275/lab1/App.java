package edu.sjsu.cmpe275.lab1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /***
         * Following is the dummy implementation of App to demonstrate bean creation with Application context.
         * Students may alter the following code as required.
         */

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        TweetService tweeter = (TweetService) ctx.getBean("tweetServiceProxy");
        TweetStats tweetStats = (TweetStats) ctx.getBean("tweetStats");

        try {
            tweeter.tweet("alex", "first tweet");
            tweeter.tweet("alex", "first tweet1");
            tweeter.tweet("alex", "first tweet12");
            tweeter.tweet("alex", "first tweet123");
            tweeter.tweet("alex1", "first tweet1231111111111111111111111111111111111111111111111111111");
            tweeter.follow("alex", "bob");
            tweeter.follow("alex1", "bob");
            tweeter.follow("alex2", "bob");
            tweeter.follow("alex3", "bob");
            tweeter.follow("alex4", "bob");
            tweeter.follow("alex5", "bob");
            tweeter.follow("alex6", "bob");
            tweeter.follow("alex", "bob1");
            tweeter.follow("alex1", "bob1");
            tweeter.follow("alex2", "bob1");
            tweeter.follow("alex6", "bob1");
            tweeter.follow("alex6", "bob1");
            tweeter.follow("alex6", "bob1");
            tweeter.follow("alex6", "bob1");
            tweeter.follow("alex", "bob2");
            tweeter.follow("alex1", "bob2");
            tweeter.follow("alex2", "bob2");
            tweeter.follow("alex3", "bob2");
            tweeter.follow("alex4", "bob2");
            tweeter.follow("alex", "aob");
            tweeter.follow("alex1", "aob");
            tweeter.follow("alex2", "aob");
            tweeter.follow("alex3", "aob");
            tweeter.follow("alex4", "aob");
            tweeter.follow("alex5", "aob");
            tweeter.follow("alex6", "aob");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
        System.out.println("Most followed user: " + tweetStats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + tweetStats.getLengthOfLongestTweetAttempted());
    }
}
