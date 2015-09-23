import java.util.ArrayList;
import java.util.Stack;


public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2}; //{1,2,3,4,5,6,7};
		rotate_1(nums, 6);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
	
	/**
	 * Rotate an array of n elements to the right by k steps.
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
	 * is rotated to [5,6,7,1,2,3,4].
	 * Note:
	 * Try to come up as many solutions as you can, there are at least 3 
	 * different ways to solve this problem.
	 * 
	 * @param nums
	 * @param k
	 */
	// Solution 1 344 ms
	public static void rotate_1(int[] nums, int k) {		
        Stack<Integer> stack = new Stack<Integer>();
       
        int size = nums.length;
		k = k%size;
        for (int i = 0; i < k; i++)
        	stack.push(nums[size-1-i]);
        
        for(int i = 0; i < size - k; i++)
        	nums[size-1-i] = nums[size-1-k-i];
        
        int n = 0;
        while(!stack.isEmpty())
        	nums[n++] = stack.pop();
    }
	
	public static void rotate_2(int[] nums, int k){

		ArrayList<Integer> a = new ArrayList<Integer>();

	    k = k%nums.length;

	    if (k == 0 || nums.length <= 1) {
	        return;
	    }

	    int count = 0;

	    for (int h= nums.length-k; h<= nums.length-1; h++ ) {
	        a.add(nums[h]);
	    }

	    while (!a.isEmpty() && count< nums.length) {
	        a.add(nums[count]);
	        nums[count] = a.get(count++);
	    }

	}
}
