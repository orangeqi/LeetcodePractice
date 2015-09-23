import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;


public class ComtainsDuplicate {

	/** 217 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,10,4,10,16,13};
		System.out.println(containsDuplicate_1(nums));
	}
	
	/**
	 * Given an array of integers, find if the array contains any 
	 * duplicates. Your function should return true if any value 
	 * appears at least twice in the array, and it should return 
	 * false if every element is distinct.
	 * 
	 * @param nums
	 * @return true if there is a duplicate
	 */
	// solution 1 524 ms
	public static boolean containsDuplicate_1(int[] nums) {
        if (nums.length == 0 || nums == null)
        	return false;
        
		// red black tree map
        TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
        	if (count.containsKey(nums[i]))
        		return true;
        	else
        		count.put(nums[i], 1);
        }
		
		return false;
    }
	
	// solution 2 460ms
	public static boolean containsDuplicate_2(int[] nums){
        if (nums.length == 0 || nums == null)
        	return false;
        
		// a collection that contains no duplicate elements
		Set<Integer> set = new HashSet<Integer>();
		for(int i : nums)
			if (!set.add(i)) return true;
		return false;
	}
}
