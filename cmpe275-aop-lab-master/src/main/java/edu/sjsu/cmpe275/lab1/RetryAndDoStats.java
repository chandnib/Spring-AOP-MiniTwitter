package edu.sjsu.cmpe275.lab1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Parteek
 *
 */
public class RetryAndDoStats implements MethodInterceptor
{

	/**
	 * This method is used to intercept tweet and follow method before the
	 * invocation, after result and after exception It is populating data
	 * required by TweetStatsImpl static Variable
	 * 
	 * @param invocation
	 * @return Object
	 * @throws Throwable
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable
	{

		/* Object result to return after method invocation */
		Object result = null;
		/* Boolean variable for retrying again after network failure */
		boolean retrybool = true;

		/*
		 * Intercepting method tweet before invocation for finding out the
		 * longest tweet length
		 */
		if (invocation.getMethod().getName().equals("tweet"))
		{
			int currTweetLength = invocation.getArguments()[1].toString().length();
			System.out.println(currTweetLength);
			if (currTweetLength > TweetStatsImpl.longestTweetLength)
				TweetStatsImpl.longestTweetLength = currTweetLength;
			String user = invocation.getArguments()[0].toString();
			String tweet = invocation.getArguments()[1].toString();
			/*
			 * This while loop will run till method throws no exception or 3
			 * retry's also failed
			 */
			while (retrybool)
			{
				try
				{
					result = invocation.proceed();
					retrybool = false;
					TweetStatsImpl.retryCounter = 3;
					TreeMap<String, Integer> productiveUserMap = TweetStatsImpl.productiveUserMap;
					/*
					 * If tweet length is greater then 140 then that doesnt
					 * count for productive user
					 */
					if (tweet.length() <= 140)
					{
						if (productiveUserMap.containsKey(user))
						{
							productiveUserMap.put(user, productiveUserMap.get(user) + tweet.length());
						}
						productiveUserMap.put(user, tweet.length());
					}
				}
				catch (IOException ex)
				{
					/*
					 * If exception is there retry till retry counter is greater
					 * then 0
					 */
					if (TweetStatsImpl.retryCounter > 0)
					{
						TweetStatsImpl.retryCounter--;
					}
					else
					{
						/* Set retrybool to false and retrycounter back to 3 */
						retrybool = false;
						TweetStatsImpl.retryCounter = 3;
					}
				}
				catch (IllegalArgumentException illegalException)
				{
					System.out.println("Tweet Length is more then 140 characters");
					retrybool = false;
				}
				catch (Exception ex)
				{
					retrybool = false;
				}
			}
		}

		/*
		 * Intercepting method follow before invocation for finding out the
		 * longest tweet length
		 */
		if (invocation.getMethod().getName().equals("follow"))
		{
			while (retrybool)
			{
				try
				{
					result = invocation.proceed();
					retrybool = false;
					TweetStatsImpl.retryCounter = 3;
					String follower = invocation.getArguments()[0].toString();
					String followee = invocation.getArguments()[1].toString();
					TreeMap<String, Set<String>> followerMap = TweetStatsImpl.followerMap;
					Set<String> followerSet;
					if (followerMap.containsKey(followee))
					{
						followerSet = followerMap.get(followee);
					}
					else
					{
						followerSet = new HashSet<String>();
					}
					followerSet.add(follower);
					followerMap.put(followee, followerSet);
				}
				catch (IOException ex)
				{
					/*
					 * If exception is there retry till retry counter is greater
					 * then 0
					 */
					if (TweetStatsImpl.retryCounter > 0)
					{
						TweetStatsImpl.retryCounter--;
					}
					else
					{
						/* Set retrybool to false and retrycounter back to 3 */
						retrybool = false;
						TweetStatsImpl.retryCounter = 3;
					}
				}
				catch (Exception ex)
				{
					retrybool = false;
					ex.printStackTrace();
				}
			}
		}
		retrybool = true;
		return result;
	}
}
