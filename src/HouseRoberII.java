import java.util.Arrays;


public class HouseRoberII {
	
	/** 213 M
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(rob_2(new int[]{6,6,4,8,4,3,3,10}));
	}
	
	/**
	 * After robbing those houses on that street, the thief has found himself 
	 * a new place for his thievery so that he will not get too much attention. 
	 * This time, all houses at this place are arranged in a circle. 
	 * That means the first house is the neighbor of the last one. 
	 * Meanwhile, the security system for these houses remain the same as for 
	 * those in the previous street.
	 * 
	 * Given a list of non-negative integers representing the amount of money 
	 * of each house, determine the maximum amount of money you can rob tonight 
	 * without alerting the police.
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 Two-passes 256 ms
	// Reference: https://leetcode.com/discuss/36497/concise-java-dp-with-two-passes
	public static int rob_1(int[] nums) {
	    int n = nums.length;
	    int[][] P = new int[2][n];

	    if (n == 0)
	        return 0;

	    for (int k = 0; k < 2; k++) {
	        for (int i = k; i < n + k; i++) {
	            P[k][i % n] = Math.max(
	                    (i >= 1 ? P[k][i - 1] : 0),
	                    (i >= 2 ? P[k][i - 2] : 0) + (P[k][(i + 1) % n] == 0 ? nums[i % n] : 0));
	        }
	    }

	    retur Math.max(P[0][n - 1], P[1][0]);
	}
	
	// Solution 2 280 ms
	// Reference: https://leetcode.com/discuss/36544/simple-ac-solution-in-java-in-o-n-with-explanation
	public static int rob_2(int[] nums) {
	    if (nums.length == 1) return nums[0];
	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}
	private static int rob(int[] num, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int j = lo; j <= hi; j++) {
	        int i = include, e = exclude;
	        include = e + num[j];
	        exclude = Math.max(e, i);
	    }
	    return Math.max(include, exclude);
	}
	
	// Solution 3 284 ms
	// Reference: https://leetcode.com/discuss/37300/java-ac-solution-dynamic-programming
	int cache[];

	  /** House Rubber Solution II */
	  public int rob_3(int[] num) {
	    if ((num==null) ||num.length==0) return 0; 
	    if (num.length==1) return num[0];

	    /** Maximun result of rubbing [first house..last hourse-1]
	     *  and [second house .. last house] 
	     **/
	    return Math.max(_rob(Arrays.copyOfRange(num, 0, num.length-1)), 
	    		_rob(Arrays.copyOfRange(num, 1, num.length)));
	  }

	  /** House Rubber Solution I */
	  public int _rob(int[] num) {
	    cache = new int[num.length];
	    Arrays.fill(cache, -1);  //init cache
	    return maxRob(0, num);
	 }

	  private int maxRob(int i, int[] num) {
	    if (i >= num.length) return 0;
	    if (cache[i]!=-1) return cache[i];
	    return cache[i]= Math.max(num[i] + maxRob(i+2, num), maxRob(i+1, num));
	  }
}
