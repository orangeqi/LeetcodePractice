
public class RemoveDuplicatesFromSortedArrayII {

	/** 80 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,2,2,3,3,4};
				//{1,2,2,2,2,3,3,3,4,5,5};
		//{1,1,2,3,4,4,4,5,5,6,8,8,9};
		int size = removeDuplicates(nums);
		System.out.println(size);
		for (int i = 0; i < size; i++)
			System.out.println(nums[i]);
	}
	
	/**
	 * Follow up for "Remove Duplicates":
	 * What if duplicates are allowed at most twice?
	 * For example,
	 * Given sorted array nums = [1,1,1,2,2,3],
	 * Your function should return length = 5, 
	 * with the first five elements of nums being 1, 1, 2, 2 and 3. 
	 * It doesn't matter what you leave beyond the new length.
	 * 
	 * @param nums
	 * @return
	 */
	// Solution 1 316 ms
	public static int removeDuplicates(int[] nums) {
		int size = nums.length;
		if(size < 3) return size;
		
        int pt0 = 0, pt1 = 1, count = 0;
        while(pt1 < size){
        	if (nums[pt0] == nums[pt1]){
        		count++;
        		pt1++;
        	}
        	else{
        		if (count > 0){
        			nums[pt0+1] = nums[pt1-1];
        			nums[pt0+2] = nums[pt1];
        			pt0++;
        		}
        		else if (pt1 - pt0 > 1){
        			nums[pt0+1] = nums[pt1];
        		}
        		count = 0;
        		pt1++;
        		pt0++;
        	}
        }
        if (count > 0)
        	nums[++pt0] = nums[pt1-1];
        return pt0+1;
    }
}
