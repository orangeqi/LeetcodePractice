import java.util.ArrayList;


public class Permutations {

	/** 46 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute_2(new int[]{1,2,3,4,5}));
	}

	/**
	 * Given a collection of numbers, return all possible 
	 * permutations.
	 * 
	 * For example,
	 * [1,2,3] have the following permutations:
	 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], 
	 * and [3,2,1].
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 292 ms
	public static ArrayList<ArrayList<Integer>> permute_1(int[] nums){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> start = new ArrayList<Integer>();
		start.add(nums[0]);
		list.add(start);
		if(nums.length == 1) return list;
		for (int j = 1; j < nums.length; j++){
			//System.out.println(list);
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> per : list){
				for (int i = 0; i < per.size()+1; i++){
					ArrayList<Integer> cur = new ArrayList<Integer>();
					cur.addAll(per);
					cur.add(i, nums[j]);
					temp.add(cur);
				}
			}
			list = temp;
		}
		return list;
	}
	
	// Solution 2 312 ms
	// Reference: https://leetcode.com/discuss/40364/my-recursive-solution-using-java-pretty-short-and-clean
	public static ArrayList<ArrayList<Integer>> permute_2(int[] nums) {
	    ArrayList<Integer> sorted = new ArrayList<Integer>();
	    ArrayList<Integer> left = new ArrayList<Integer>();
	    for(int num : nums) {
	        left.add(num);
	    }
	    return locateNew(sorted, left);
	}
	
	private static ArrayList<ArrayList<Integer>> locateNew(ArrayList<Integer> sorted, ArrayList<Integer> left) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if (left.size() == 0) {
	        result = new ArrayList<ArrayList<Integer>>();
	        result.add(sorted);
	        return result;
	    }
	    for (int i = 0; i< left.size() ; i++) {
	        ArrayList<Integer> newSort = new ArrayList<Integer>(sorted);
	        newSort.add(left.get(i));
	        ArrayList<Integer> newLeft = new ArrayList<Integer>(left);
	        newLeft.remove(i);
	        result.addAll(locateNew(newSort, newLeft));
	    }
	    return result;

	    }
	
}
