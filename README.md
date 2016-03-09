# Spring-AOP-MiniTwitter

# This Project is an example of taking stats using MethodInterceptor which includes 3 advices all together in it .
  RetryAndDoStats.java has all the methods which will give you the stats like longest tweet till now, Most productive
  user and Most followed user, also there is a reset method to reset the stats .
  This project is single threaded, wont be able to support multithreading .
  
 Example Stats
The following examples are assuming stats are reset() before running every single example. Additional test cases will be used for grading.
Tweet message as tweet(“foo”,”barbar”). Then getLengthOfLongestTweetAttempted() returns 6.
Alice follows Bob, Carl follows Bob (but fails to do so), and Bob follows Alice. getMostFollowedUser() returns “Alice”.
Successfully tweet a message ("Alice","[any message <= 140 chars]"), then getMostProductiveUser() returns “Alice”.



# To run this project use 
mvn install 
and run app.java file .
#To run the testcases
mvn verify
