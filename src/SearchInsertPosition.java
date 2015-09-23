
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert_2(new int[]{1,3,5,6}, 7));
	}

	/**
	 * Given a sorted array and a target value, 
	 * return the index if the target is found. 
	 * If not, return the index where it would 
	 * be if it were inserted in order.
	 * You may assume no duplicates in the array.

		Here are few examples.
		[1,3,5,6], 5 , 2
		[1,3,5,6], 2 , 1
		[1,3,5,6], 7 , 4
		[1,3,5,6], 0 , 0
		
	 * @param nums
	 * @param target
	 * @return
	 */
	// Solution 1 348 ms O(n)
	public static int searchInsert_1(int[] nums, int target) {
		if (target < nums[0])
			return 0;
        for (int i = 0; i < nums.length-1; i++){
        	if (target == nums[i])
        		return i;
        	if (i < nums.length-1 && target > nums[i] && target < nums[i+1])
        		return i + 1;
        }
        return nums.length;
    }
	
	// Solution 2 Binary search O(logn)
	// Reference: https://leetcode.com/discuss/43478/simple-binary-search-solution-in-java-o-log-n
	public static int searchInsert_2(int[] nums, int target){
		int a = 0, b = nums.length-1, c;
		while(a < b){
			c = (a+b+1)/2; // round up to avoid infinite loop when there are two elements
			if (nums[c] == target)
				return c;
			
			if (nums[c] > target)
				b = c - 1;
			else
				a = c;				
		}
		if (nums[a] < target)
			return a+1;
		return a;
		
	}
	
}
