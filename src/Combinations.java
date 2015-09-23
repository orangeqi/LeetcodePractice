import java.util.ArrayList;


public class Combinations {

	/** 77 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(3,2));
	}

	// Solution 1 276 ms
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
		
		For example,
		If n = 4 and k = 2, a solution is:
		
		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
	 * @param n
	 * @param k
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> combine(int n, int k){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (k > n) return res;
		
		helper(1, n, k, res, new ArrayList<Integer>());
		return res;
	}
	
	private static void helper(int next, int n, int k, 
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> each){
		if (k == 0) {
			res.add(each);
			return;
		}
		for (int i = next; i <= n; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>(each);
			temp.add(i);
			helper(i+1, n, k-1, res, temp);
		}
	}
}
