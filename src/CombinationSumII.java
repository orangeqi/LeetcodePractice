import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSumII {

	/** 40 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
	}

	/**
	 * Given a collection of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination.
	 * Note:
	 * All numbers (including target) will be positive integers.
	 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
	 * (ie, a1 <= a2 <= … <= ak).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	 * A solution set is: 
	 * [1, 7] 
	 * [1, 2, 5] 
	 * [2, 6] 
	 * [1, 1, 6] 
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	// Solution 1 340 ms Based on CombinationSum
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
		helper(candidates, target, res, 0, new ArrayList<Integer>());
		return res;
    }
	
	private static void helper(int[] nums, int target, 
			ArrayList<ArrayList<Integer>> res, int ind, ArrayList<Integer> comb){
		for (int i = ind; i < nums.length; i++){
			// get rid of duplicates
			if (i > ind && nums[i] == nums[i-1])
				continue;
			ArrayList<Integer> temp = new ArrayList<Integer>(comb);
			if (nums[i] == target){
				temp.add(nums[i]);
				res.add(temp);
				return;
			}
			else if (nums[i] < target){
				temp.add(nums[i]);
				helper(nums, target-nums[i], res, i+1, temp);
			}
			else{
				return;
			}
		}
		return;
	}
	
}
