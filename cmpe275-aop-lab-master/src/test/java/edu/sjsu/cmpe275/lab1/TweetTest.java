package edu.sjsu.cmpe275.lab1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.*;
import static org.junit.Assert.*;

public class TweetTest {

    @Test
    public void testOne() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        TweetService tweeter = (TweetService) ctx.getBean("tweetServiceProxy");
        TweetStats tweetStats = (TweetStats) ctx.getBean("tweetStats");
        tweetStats.resetStats();
        System.out.println("running test 1");
        try {
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "first Longest Failed tweet");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "Second Suc tweet");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "first SUC tweet");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "Second Suc tweet");
          //System.out.println("-----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
       System.out.println("Most followed user: " + tweetStats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + tweetStats.getLengthOfLongestTweetAttempted());
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        assertEquals("Alex",tweetStats.getMostProductiveUser());
        assertEquals(null,tweetStats.getMostFollowedUser());
        assertEquals(26,tweetStats.getLengthOfLongestTweetAttempted());
    }

    @Test
    public void test2() { 
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        TweetService tweeter = (TweetService) ctx.getBean("tweetServiceProxy");
        TweetStats tweetStats = (TweetStats) ctx.getBean("tweetStats");
        tweetStats.resetStats();
        System.out.println("running test 2");
        try {
          //System.out.println("-----------------------------");
            tweeter.follow("Zara", "Alex");
          //System.out.println("-----------------------------");
            tweeter.follow("Zara", "Bob");
          //System.out.println("-----------------------------");
            tweeter.follow("Alex", "Zara");
          //System.out.println("-----------------------------");
            tweeter.follow("Bob", "Alex");
          //System.out.println("-----------------------------");
            tweeter.follow("Bob", "Zara");
          //System.out.println("-----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
        System.out.println("Most followed user: " + tweetStats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + tweetStats.getLengthOfLongestTweetAttempted());
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        assertEquals(null,tweetStats.getMostProductiveUser());
        assertEquals("Zara",tweetStats.getMostFollowedUser());
        assertEquals(0,tweetStats.getLengthOfLongestTweetAttempted());
    }
  
  @Test
    public void test3() { 
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        TweetService tweeter = (TweetService) ctx.getBean("tweetServiceProxy");
        TweetStats tweetStats = (TweetStats) ctx.getBean("tweetStats");
        tweetStats.resetStats();
        try {
        	 System.out.println("running test 3");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "first Longest Failed tweet");
          ////System.out.println("-----------------------------");
            //tweeter.tweet("Zara", "Second Suc tweet");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "This is FAILEDFAILEDFAILEDFAILED 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
          //System.out.println("-----------------------------");
            tweeter.follow("Zara", "Alex");
          //System.out.println("-----------------------------");
            tweeter.follow("Zara", "Bob");
          //System.out.println("-----------------------------");
            tweeter.follow("Alex", "Zara");
          //System.out.println("-----------------------------");
            tweeter.follow("Bob", "Alex");
          //System.out.println("-----------------------------");
            tweeter.follow("Bob", "Zara");
          //System.out.println("-----------------------------");
          tweeter.follow("Bob", "Zara");
          //System.out.println("-----------------------------");
          tweeter.follow("Bob", "Zara");
          //System.out.println("-----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
        System.out.println("Most followed user: " + tweetStats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + tweetStats.getLengthOfLongestTweetAttempted());
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        assertEquals("Alex",tweetStats.getMostProductiveUser());
        assertEquals("Zara",tweetStats.getMostFollowedUser());
        assertEquals(154,tweetStats.getLengthOfLongestTweetAttempted());
    }
  
   @Test
    public void test4() { 
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        TweetService tweeter = (TweetService) ctx.getBean("tweetServiceProxy");
        TweetStats tweetStats = (TweetStats) ctx.getBean("tweetStats");
        tweetStats.resetStats();
        try {
        	 System.out.println("running test 4");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "first Longest Failed tweet");
          ////System.out.println("-----------------------------");
            //tweeter.tweet("Zara", "Second Suc tweet");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Zara", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "This is Tweet 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
            tweeter.tweet("Alex", "This is FAILEDFAILEDFAILEDFAILED 1111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222233333333333333333344");
          //System.out.println("-----------------------------");
          //System.out.println("-----------------------------");
            tweeter.follow("Zara", "Alex");
          //System.out.println("-----------------------------");
            tweeter.follow("Zara", "Bob");
          //System.out.println("-----------------------------");
            tweeter.follow("Alex", "Zara");
          //System.out.println("-----------------------------");
            tweeter.follow("Bob", "Alex");
          //System.out.println("-----------------------------");
            tweeter.follow("Bob", "Cassie");
          //System.out.println("-----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
        System.out.println("Most followed user: " + tweetStats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + tweetStats.getLengthOfLongestTweetAttempted());
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        assertEquals("Alex",tweetStats.getMostProductiveUser());
        assertEquals("Alex",tweetStats.getMostFollowedUser());
        assertEquals(154,tweetStats.getLengthOfLongestTweetAttempted());
    }
}
