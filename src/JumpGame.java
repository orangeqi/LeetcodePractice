
public class JumpGame {

	/** 55 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canJump_2(new int[]{3,2,1,0,4}));
	}

	/**
	 * Given an array of non-negative integers, you are 
	 * initially positioned at the first index of the array.
	 * Each element in the array represents your maximum jump 
	 * length at that position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example:
	 * 
	 * A = [2,3,1,1,4], return true.
	 * A = [3,2,1,0,4], return false.
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 Stack overflow
	public static boolean canJump_1(int[] nums) {
		if (nums.length == 0) return false;
		return canJump_helper(nums, nums.length-1);
    }
	
	private static boolean canJump_helper(int[] nums, int i){
		if (i == 0)
        	return true;
		
		for (int k = i-1; k > -1; k--){
        	if (nums[k] > i-k-1){
        		return canJump_helper(nums, k);  
        	}
        }
		
		return false;
	}
		
	// Solution 2 364 ms
	public static boolean canJump_2(int[] A) {
        int tail = A.length - 1;
        for(int i = A.length-2; i > -1; i--) 
        	if(i+A[i] >= tail) 
        		tail = i;
        
        return tail==0;
	}

	// Solution 3 396 ms
	// Reference: https://leetcode.com/discuss/48551/6-line-java-solution-in-o-n
	public static boolean canJump_3(int[] nums) {
	    int reachable = 0;
	    for (int i=0; i<nums.length; ++i) {
	        if (i > reachable) return false;
	        reachable = Math.max(reachable, i + nums[i]);
	    }
	    return true;
	}
}
