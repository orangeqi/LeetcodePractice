
public class RemoveElement {

	/** 27 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,1,1,1,1,2};
		//{1,1,2,3,4,4,4,5,5,6,8,8,9};
		int size = removeElement(nums, 1);
		System.out.println(size);
		for (int i = 0; i < size; i++)
			System.out.println(nums[i]);
	}

	/**
	 * Given an array and a value, remove all instances of 
	 * that value in place and return the new length.
	 * 
	 * The order of elements can be changed. 
	 * It doesn't matter what you leave beyond the new length.
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	// Solution 1 284 ms
	public static int removeElement(int[] nums, int val){
		int  pt = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[pt] = nums[i];
				pt++;
			}
		}
		return pt;
	}
}
