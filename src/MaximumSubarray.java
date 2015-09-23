
public class MaximumSubarray {
	/** 53 M
	 * @param args
	 */
	public static void main(String[] args){
		
	}

	/**
	 * Find the contiguous subarray within an array 
	 * (containing at least one number) which has the largest sum.
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 340 ms
	// Reference: https://leetcode.com/discuss/47559/java-o-n-solution-using-dp
	public static int maxSubArray(int[] nums){
		if (nums.length == 0)
			return 0;
		
		int[] max = new int[nums.length];
		max[0] = nums[0];
		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++){
			max[i] = Math.max(nums[i], nums[i] + max[i-1]);
			maxIndex = max[i] > max[maxIndex] ? i : maxIndex;
		}
		
		return max[maxIndex];
	}
}
