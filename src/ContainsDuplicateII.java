import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class ContainsDuplicateII {

	/** 219 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-2,-1};
		System.out.println(containsNearByDuplicate_1(nums, 0));
	}
	
	/**
	 * Given an array of integers and an integer k,
	 * find out whether there there are two distinct indices i 
	 * and j in the array such that nums[i] = nums[j] and 
	 * the difference between i and j is at most k.
	 * 
	 * @param nums
	 * @param k
	 * @return true if there is a duplicate
	 */
	
	// solution 1 476 ms
	public static boolean containsNearByDuplicate_1(int[] nums, int k){
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int i = 0;
		
		for (int num : nums)
			if (map.containsKey(num) && (i - map.get(num) <= k))
				return true;
			else {
				map.put(num, i);
				System.out.println("key" + num + "index" + i);
				i++;
			}
		
		return false;
	}

	// solution 1 364 ms
	public static boolean containsNearByDuplicate_2(int[] nums, int k){
		if(nums == null){
            return false;
        }
        Map<Integer,Integer> check = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i ++){
            if(check.containsKey(nums[i])){
                if( i - check.get(nums[i]) <= k){
                    return true;
                }
            }
            check.put(nums[i], i);
        }
        return false;
	}
}
