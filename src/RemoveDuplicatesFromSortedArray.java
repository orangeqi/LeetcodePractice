
public class RemoveDuplicatesFromSortedArray {

	/** 26 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2};
				//{1,1,2,3,4,4,4,5,5,6,8,8,9};
		int size = removeDuplicates(nums);
		System.out.println(size);
		for (int i = 0; i < size; i++)
			System.out.println(nums[i]);
	}

	/**
	 * Given a sorted array, remove the duplicates in place 
	 * such that each element appear only once and return 
	 * the new length.
	 * 
	 * Do not allocate extra space for another array, 
	 * you must do this in place with constant memory.
	 * 
	 * For example,
	 * Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, 
	 * with the first two elements of nums being 1 and 2 respectively. 
	 * It doesn't matter what you leave beyond the new length.
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 408 ms
	public static int removeDuplicates(int[] nums) {
		int size = nums.length;
		if (size < 2)
			return size;
		int pt0 = 0, pt1 = 1;
        while(pt1 < size){
        	if(nums[pt0] == nums[pt1]){
        		pt1++;
        	}
        	else{
        		if (pt1 - pt0 > 1){
        			nums[pt0+1] = nums[pt1];
        		}
        		pt0++;
        		pt1++;
        	}
        }
        return pt0+1;
    }

}
