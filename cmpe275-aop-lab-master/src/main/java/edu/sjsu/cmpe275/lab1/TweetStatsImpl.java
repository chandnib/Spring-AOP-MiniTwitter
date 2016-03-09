package edu.sjsu.cmpe275.lab1;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Parteek
 *
 */

public class TweetStatsImpl implements TweetStats
{

	/* Following are the static data variable to store the information */

	/**
	 * Static Variable to hold the Longest Tweet Length
	 */
	public static int longestTweetLength = 0;
	/**
	 * Static map to hold the user as a key and followers as values in Set
	 */
	public static TreeMap<String, Set<String>> followerMap = new TreeMap<String, Set<String>>();
	/**
	 * Static map to hold all the users as key and value as there length of
	 * tweet
	 */
	public static TreeMap<String, Integer> productiveUserMap = new TreeMap<String, Integer>();
	/**
	 * Retry counter for retrying against network failure
	 */
	public static int retryCounter = 3;

	/**
	 * This function is used to reset all the static variable It is clearing the
	 * maps and setting the tweet length to 0
	 */
	@Override
	public void resetStats()
	{
		longestTweetLength = 0;
		followerMap.clear();
		productiveUserMap.clear();
	}

	/**
	 * @return the length of longest message attempted since the beginning or
	 *         last reset. Can be more than 140. Failed messages are counted for
	 *         this as well.
	 */
	@Override
	public int getLengthOfLongestTweetAttempted()
	{
		return longestTweetLength;
	}

	/**
	 * @return the user who has been followed by the biggest number of different
	 *         users since the beginning or last reset. If there is a tie,
	 *         return the 1st of such users based on alphabetical order. If the
	 *         follow action did not succeed, then it does not count into the
	 *         stats
	 */
	@Override
	public String getMostFollowedUser()
	{
		int maxFollowerUser = 0;
		String user = null;
		/* If size of map is 0 then return null as no user is there in map */
		if (followerMap.size() != 0)
		{
			for (Map.Entry<String, Set<String>> entry : followerMap.entrySet())
			{
				/*
				 * Comparing the values with previous value to find the first
				 * largest one
				 */
				String currUser = entry.getKey();
				int currSize = entry.getValue().size();
				if (currSize > maxFollowerUser)
				{
					user = currUser;
					maxFollowerUser = currSize;
				}
			}
			return user; /*
							 * As we are using treemap so first user will be one
							 * required according to alphabetical order
							 */
		}
		return null;
	}

	/**
	 * The most productive user is determined by the total length of all the
	 * messages successfully tweeted since the beginning or last reset. If there
	 * is a tie, return the 1st of such users based on alphabetical order.
	 *
	 * @return the most productive user.
	 */
	@Override
	public String getMostProductiveUser()
	{
		int maxProductiveUser = 0;
		String user = null;
		/* If size of map is 0 then return null as no user is there in map */
		if (productiveUserMap.size() != 0)
		{
			for (Map.Entry<String, Integer> entry : productiveUserMap.entrySet())
			{
				/*
				 * Comparing the values with previous value to find the first
				 * largest one
				 */
				String currUser = entry.getKey();
				int currSize = entry.getValue();
				if (currSize > maxProductiveUser)
				{
					user = currUser;
					maxProductiveUser = currSize;
				}
			}
			return user; /*
							 * As we are using treemap so first user will be one
							 * required according to alphabetical order
							 */
		}
		return null;
	}

}
