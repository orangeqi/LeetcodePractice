import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {

	/** 78 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println(subsets_2(new int[]{1,2,3}));
	}

	/**
	 * Given a set of distinct integers, nums, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If nums = [1,2,3], a solution is:
		
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
	 * @param nums
	 * @return
	 */
	// Solution 1 324 ms
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++){
			int m = res.size();
			for (int j = 0; j < m; j++){
				ArrayList<Integer> each = new ArrayList<Integer>(res.get(j));
				each.add(nums[i]);
				res.add(each);
			}
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(nums[i]);
			res.add(a);
		}
		res.add(new ArrayList<Integer>());
		return res;
	}
	
	// Solution 2 248 ms dfs
	public static ArrayList<ArrayList<Integer>> subsets_2(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums.length == 0) return res;
		Arrays.sort(nums);
		res.add(new ArrayList<Integer>());
		helper(nums, 0, res, new ArrayList<Integer>());
		return res;
    }
	
	public static void helper(int[] nums, int ind, 
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub){
		for (int i = ind; i < nums.length; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>(sub);
			temp.add(nums[i]);
			res.add(temp);
			helper(nums, i+1, res, temp);
        }
	}
	
}
