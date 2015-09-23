import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class ThreeSums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum_2(new int[]{-1,0,1,2,-1,-4}));
	}

	
	/**
	 * Given an array S of n integers, are there elements 
	 * a, b, c in S such that a + b + c = 0? Find all unique 
	 * triplets in the array which gives the sum of zero.
	 * Note:
	 * Elements in a triplet (a,b,c) must be in non-descending order. 
	 * (a <= b <= c)
	 * The solution set must not contain duplicate triplets.
	 * For example, given array S = {-1 0 1 2 -1 -4},
	 * A solution set is:(-1, 0, 1),(-1, -1, 2)
	 *    
	 * @param nums
	 * @return
	 */
	
	// Solution 1 time limit exceeded
	public static ArrayList<ArrayList<Integer>> threeSum_1(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
       
        int diff;
        for (int i = 2; i < nums.length; i++){
        	diff = 0-nums[i];
        	ArrayList<ArrayList<Integer>> twoSumList = twoSum(nums, i, diff);
        	if (!twoSumList.isEmpty()){
        		for (int k = 0; k < twoSumList.size(); k++){
        			ArrayList<Integer> a = twoSumList.get(k);
        			a.add(nums[i]);
	        		Collections.sort(a);
	        		if (!list.contains(a))
	        			list.add(a);
        		}
        	}	
        }
        
        return list;
    }
	private static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int i, int diff){
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<ArrayList<Integer>> twoSumList = new ArrayList<ArrayList<Integer>>();
		
		int d;
		for(int k = 0; k < i; k++){
			if (k > 0){
				d = diff - nums[k];
				if (set.contains(d)){
					ArrayList<Integer> sublist = new ArrayList<Integer>();
					sublist.add(d);
					sublist.add(nums[k]);
					twoSumList.add(sublist);
				}
			}
			set.add(nums[k]);
		}
		return twoSumList;
	}
	
	// Solution 2 388 ms
	// Reference: https://leetcode.com/discuss/34628/an-o-n-2-java-solution-402-ms
	public static ArrayList<ArrayList<Integer>> threeSum_2(int[] nums) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if (nums == null) {
	            return result;
	        }
	        Arrays.sort(nums);
	        int index = 0;
	        while (index < nums.length - 2 && nums[index] <= 0) {
	            if (result.size() != 0 && index > 0 && nums[index] == nums[index - 1]) {
	                index ++;
	                continue;
	            }
	            int front = index + 1;
	            int tail = nums.length - 1;
	            while (front < tail) {
	                if (nums[front] + nums[tail] == nums[index] * (-1)) {
	                    if (!(result.size() != 0 && 
	                          result.get(result.size() - 1).get(0) == nums[index] && 
	                          result.get(result.size() - 1).get(1) == nums[front] && 
	                          result.get(result.size() - 1).get(2) == nums[tail])) {

	                        ArrayList<Integer> item = new ArrayList<Integer>();
	                        item.add(nums[index]);
	                        item.add(nums[front]);
	                        item.add(nums[tail]);
	                        result.add(item);
	                    } 
	                    front ++;
	                    tail --;
	                } else if (nums[front] + nums[tail] < nums[index] * (-1)) {
	                    front ++;
	                } else {
	                    tail --;
	                }
	            }
	            index ++;
	        }
	        return result;
		}
}
