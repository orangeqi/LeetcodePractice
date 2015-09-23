
public class SearchInRotatedSortedArray {

	/** 33 H
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. 
	 * If found in the array return its index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static boolean search(int[] nums, int target){
		int a = 0, b = nums.length - 1;
		
		while (a < b){
			int mid = (a + b + 1)/2;
			if (nums[mid] > target){
				
			}
			else{
				
			}
		}
	}

}
