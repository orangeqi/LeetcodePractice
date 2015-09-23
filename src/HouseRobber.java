
public class HouseRobber {
	/** 198 E
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(rob(new int[]{1,2,3,5}));
	}
	
	/** 
	 * You are a professional robber planning to rob houses along a street.
	 * Each house has a certain amount of money stashed, the only constraint 
	 * stopping you from robbing each of them is that adjacent houses have 
	 * security system connected and it will automatically contact the police 
	 * if two adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money 
	 * of each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 Dynamic 272 ms
	public static int rob(int[] nums){
		// use Integer instead of int to avoid TLE when input are all 0s
			Integer[]cache = new Integer[nums.length+1];
			return Math.max(rob_helper(nums, 0, cache),
					rob_helper(nums, 1, cache));
	}
	
	public static int rob_helper(int[] nums, int index, Integer[] cache){
		if (index > nums.length-1)
			return 0;
		if (cache[index] != null) 
			return cache[index];
		cache[index] = nums[index] + Math.max(rob_helper(nums, index+2, cache),
						rob_helper(nums, index+3, cache));
		retur cache[index];
	}
	
	// Solution 2 296 ms
	// https://leetcode.com/discuss/45460/accepted-clean-java-dp-solution-with-explanation
	public int rob_2(int[] a) {
		  if (a == null || a.length == 0)
		    return 0;

		  // dp(i) represents the max money we can rob till house (i-1)
		  // dp(i) = money of house (i-1) + max {previous non-adjacent houses start from i-2}
		  int[] dp = new int[a.length + 1];
		  dp[1] = a[0];

		  // at least let's rob one!
		  int max = a[0];

		  for (int i = 2; i <= a.length; i++) {
		    for (int j = i - 2; j >= 0; j--) {
		      dp[i] = Math.max(dp[i], dp[j] + a[i - 1]);
		    }

		    max = Math.max(max, dp[i]);
		  }

		  return max;
		}
	
}
