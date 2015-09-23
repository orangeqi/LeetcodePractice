import java.util.Arrays;


public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest_1(new int[]{-1,2,1,-4}, 1));
	}
	
	/**
	 * Given an array S of n integers, find three integers 
	 * in S such that the sum is closest to a given number, 
	 * target. Return the sum of the three integers. 
	 * You may assume that each input would have exactly 
	 * one solution.
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * The sum that is closest to the target is 2. 
	 * (-1 + 2 + 1 = 2).
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	// Solution 1 324ms
	public static int threeSumClosest_1(int[] nums, int target) {
		if (nums == null || nums.length < 3) return 0;
		
		int f, b, sum, min = Integer.MAX_VALUE, ret = 0;
		Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
        	f = i + 1;
        	b = nums.length -1;
        	
        	while (f < b){
        		sum = nums[i] + nums[f] + nums[b];
        		
        		if (sum == target)
        			return target;

        		if (Math.abs(sum - target) < min){
        			min = Math.abs(sum - target);
        			ret = sum;
        		}
        		
        		if (sum > target)
        			b--;
        		else
        			f++;
        		
        	}
        }
        return ret;
    }
}
