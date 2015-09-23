import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {

	/** 39 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum(new int[]{1,2,6,3,7}, 7));
	}

	/**
	 * Given a set of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * The same repeated number may be chosen from C unlimited number of times.
	 * Note:
	 * All numbers (including target) will be positive integers.
	 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
	 * (ie, a1 <= a2 <= … <= ak).
	 * 
	 * The solution set must not contain duplicate combinations.
	 * 
	 * For example, given candidate set 2,3,6,7 and target 7, 
	 * A solution set is: 
	 * [7] 
	 * [2, 2, 3] 
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	// Solution 1 308 ms
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
		helper(candidates, target, res, 0, new ArrayList<Integer>());
		return res;
    }
	
	private static void helper(int[] nums, int target, 
			ArrayList<ArrayList<Integer>> res, int ind, ArrayList<Integer> comb){
		for (int i = ind; i < nums.length; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>(comb);
			if (nums[i] == target){
				temp.add(nums[i]);
				res.add(temp);
				return;
			}
			else if (nums[i] < target){
				temp.add(nums[i]);
				helper(nums, target-nums[i], res, i, temp);
			}
			else{
				return;
			}
		}
		return;
	}
}
