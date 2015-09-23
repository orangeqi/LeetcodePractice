import java.util.ArrayList;
import java.util.Arrays;


public class SubsetsII {

	/** 90 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsetsWithDup_1(new int[]{1,2,2}));
	}
	
	/**
	 * 
	 * Given a collection of integers that might contain 
	 * duplicates, nums, return all possible subsets.
	 * 
	 * Note:
	 * Elements in a subset must be in non-descending order.
	 * The solution set must not contain duplicate subsets.
	 * 
	 * For example,
	 * If nums = [1,2,2], a solution is:

		[
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]
		
	 * @param nums
	 * @return
	 */
	// Solution 1 280 ms dfs
	public static ArrayList<ArrayList<Integer>> subsetsWithDup_1(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums.length == 0) return res;
		Arrays.sort(nums);
		res.add(new ArrayList<Integer>());
		helper_1(nums, 0, res, new ArrayList<Integer>());
		return res;
    }
	
	public static void helper_1(int[] nums, int ind, 
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub){
		for (int i = ind; i < nums.length; i++){
			if (i > ind && nums[i] == nums[i-1]) continue;
			ArrayList<Integer> temp = new ArrayList<Integer>(sub);
			temp.add(nums[i]);
			res.add(temp);
			helper_1(nums, i+1, res, temp);
        }
	}
}
