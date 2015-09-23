
public class SearchForaRange {

	/** 34 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,5,5,5};
		int[] range = searchRange_1(nums, 5);
		for (int num : range)
			System.out.println(num);
	}
	
	/**
	 * Given a sorted array of integers, find the starting
	 * and ending position of a given target value.
	 * Your algorithm's runtime complexity must be in the 
	 * order of O(log n).
	 * If the target is not found in the array, return [-1, -1].

		For example,
		Given [5, 7, 7, 8, 8, 10] and target value 8,
		return [3, 4].
		
	 * @param nums
	 * @param target
	 * @return
	 */

	// Solution 1 binary search 376 ms
	public static int[] searchRange_1(int[] nums, int target) {
       	int[] range = {-1,-1};
		if (nums == null || nums.length == 0 ||
				target < nums[0] || target > nums[nums.length-1])
        	return range;
		int size = nums.length, l = 0, r = size-1, mid = 0;
		boolean exist = false;
        while(l <= r){
        	mid = (l+r) / 2;
        	if (l == r && r == mid){
        		if (target == nums[mid])
        			exist = true;
        		else
        			exist = false;
        		break;
        	}
        	if (target == nums[mid]){
        		exist = true;
        		break;
        	}
        	else if (target > nums[mid]) l = mid+1;
        	else r = mid;
        }
        
        if (exist){
	        l = mid -1;
	        r = mid +1;
	        while(l > -1 && nums[l] == target)
	        	l--;
	        while(r < nums.length && nums[r] == target)
	        	r++;
	        range[0] = l+1;
	        range[1] = r-1;
	        return range;
        }
        else
        	return range;
    }

}
