
public class NextPermutation {

	/** 31 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{5,3,1,4,2};
		nextPermutation(nums);
		for(int num : nums)
			System.out.print(num);
	}
	
	/**
	 * Implement next permutation, which rearranges numbers into 
	 * the lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it 
	 * as the lowest possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column 
	 * and its corresponding outputs are in the right-hand column.
		1,2,3 -> 1,3,2
		3,2,1 -> 1,2,3
		1,1,5 -> 1,5,1
	 *
	 * @param nums
	 */
	// from the tail, find the smallest digit that is larger 
	// than current one in lower decimal places
	// interchange these two
	// reverse digits after current index to get the min sub number
	// Solution 1 324 ms
	public static void nextPermutation(int[] nums){
		int index = findIndex(nums);
		reverse(nums, index);		
	}

	private static int findIndex(int[] nums){
		for (int i = nums.length-2; i > -1; i--){
			for (int j = nums.length-1; j > i; j--){
				if (nums[j] > nums[i]){
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					return i;
				}
			}
		}
		
		return -1;
	}
	private static void reverse(int[] nums, int index){
		int a = index+1, b = nums.length-1;
		while(a < b){
			int temp = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
			a++;
			b--;
		}
	}
}
