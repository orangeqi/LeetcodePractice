import java.util.TreeMap;


public class TwoSum {

	/** 1 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,2};
		int[] index = twoSum(nums, 4);
		System.out.println(index[0] + ", " + index[1]);
	}

	/**
	 * Given an array of integers, find two numbers such that 
	 * they add up to a specific target number. The function 
	 * twoSum should return indices of the two numbers such 
	 * that they add up to the target, where index1 must be 
	 * less than index2. Please note that your returned answers 
	 * (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one 
	 * solution.
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 * 
	 * @param nums
	 * @return
	 */
	
	// Solution 1 392 ms
	public static int[] twoSum(int[] nums, int target){
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		int size = nums.length;
		int[] index = new int[2];
		for (int i = 0; i < size; i++){
			if (i > 0 && map.containsKey(target - nums[i])){
				index[1] = i+1;
				index[0] = map.get(target - nums[i]) + 1;
			}
			if (!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}
		}
		return index;
	}
}
