
public class ClimbingStairs {
	/** 70 E
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(climbStairs_1(4));
	}
	
	/** 
	 * You are climbing a stair case. 
	 * It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. 
	 * In how many distinct ways can you climb to the top?
	 * 
	 * @param n
	 * @return
	 */
	// Solution 1 Dynamic Programming Recursion 220 ms
	// Reference: https://leetcode.com/discuss/32363/classic-dynamic-programming-recursion
	public static int climbStairs_1(int n){
		return (n<=1) ? n : climb(n, new int[n+1]);
    }
    private static int climb(int n, int[] cache) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(cache[n] > 0) return cache[n];
        cache[n] = climb(n-1, cache)+climb(n-2, cache);
        return cache[n];
	}
	
    /*
     * Solution 2 268 ms
	 * This is a fibonacci sequence starting with 1,2 instead of 1,1. See Pattern below:

		n_Value Solution
		
		<=0 0
		
		1 -> 1
		
		2 -> 2
		
		3 -> 3
		
		4 -> 5
		
		5 -> 8
		
		6 -> 13
	 * */
	// Reference: https://leetcode.com/discuss/38314/climbing-stairs-java-solution
	public static int climbStairs_2(int n){
		if(n == 0 || n == 1 || n == 2){
	        return n;
	    }

	    int[] ways = new int[n + 1];
	    ways[0] = 0;
	    ways[1] = 1;
	    ways[2] = 2;

	    for(int i = 3 ; i <= n; i++){
	        ways[i] = ways[i-1] + ways[i-2];
	    }

	    return ways[n];
	}
}
