import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class ContainDuplicateIII {

	/** 220 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,10,4,10,16,13};
		System.out.println(containsNearbyAlmostDuplicate_2(nums, 3, 10));
	}

	/**
	 * Given an array of integers, find out whether there 
	 * are two distinct indices i and j in the array such 
	 * that the difference between nums[i] and nums[j] is 
	 * at most t and the difference between i and j is at 
	 * most k.
	 * 
	 * @param nums
	 * @param k difference of i and j
	 * @param t difference of nums[i] and nums[j]
	 * @return true there is a pair of such numbers
	 */
	
	// Solution 1 time limit exceeded
	public static boolean containsNearbyAlmostDuplicate_1(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0)
			return false;
		
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int i = 0;
        
        for(int num : nums){
        	for (int n = 0; n <= t; n++) {
        		if ((map.containsKey(num+n) && Math.abs(map.get(num+n) - i) <= k)
        				|| (map.containsKey(num-n) && Math.abs(map.get(num-n) - i) <= k))
        			return true;
        	}
        	map.put(num, i);
        	// System.out.println(num + "index" + i);
        	i++;
        }
		return false;
    }
	
	// Solution 2 480 ms
	public static boolean containsNearbyAlmostDuplicate_2(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0)
		   return false;

        final TreeSet<Integer> values = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            final Integer max = values.floor(nums[i] + t);
            final Integer min = values.ceiling(nums[i] - t);
            if ((max != null && max >= nums[i])
                    || (min != null && min <= nums[i])) {
                return true;
            }
            // a window based on the indices 
            values.add(nums[i]);
            if (i >= k) { // remove the element that is out of index range
                values.remove(nums[i - k]);
            }
        }

        return false;
	}
	
	// Solution 3 444ms
	?
	public boolean containsNearbyAlmostDuplicate_3(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0)
			return false;
		
	    Map<Long, Long> map = new LinkedHashMap<Long, Long>();
	    for (int i = 0; i < nums.length; i++) {
	        long j = t == 0 ? (long) nums[i] - Integer.MIN_VALUE : 
	        	(((long) nums[i] - Integer.MIN_VALUE) / t);
	        if (map.containsKey(j) || 
	        		(map.containsKey(j - 1) && 
	        				Math.abs(map.get(j - 1) - nums[i]) <= t)
	                || (map.containsKey(j + 1) && 
	                		Math.abs(map.get(j + 1) - nums[i]) <= t)) return true;
	        if (map.keySet().size() == k) 
	        	map.remove(map.keySet().iterator().next());
	        map.put(j, (long) nums[i]);
	    }
	    return false;
	}
	
	// Solution 4 408ms
	?
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
