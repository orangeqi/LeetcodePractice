import java.util.ArrayList;
import java.util.Vector;


public class SummaryRanges {

	/** 228 E
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		//{-1};
		// {}; {0, 2, 3}; {0,1,2,4,5,7}; {0,1,2,4,5,6};
		System.out.println(SummaryRanges_2(nums));
	}
	
	
	/**
	 * Given a sorted integer array without duplicates, 
	 * return the summary of its ranges.
	 * For example, given [0,1,2,4,5,7], 
	 * return ["0->2","4->5","7"].
	 * 
	 * @return A String of Ranges
	 */
	
	// Solution 1 252ms
	public static ArrayList<String> SummaryRanges_1(int[] nums){
		ArrayList<String> ranges = new ArrayList<String>();
		
		if (nums.length == 0 || nums == null) 
			return ranges;
		else if(nums.length == 1) {
			ranges.add(Integer.toString(nums[0]));
			return ranges;
		}
		
		int min = nums[0];
		int max = nums[0];
		
		// iterate through entire array except the last one
		for (int index = 0; index < nums.length-1; index++){
			
			// check the difference of two adjacent elements
			if ((nums[index+1] - nums[index]) != 1){		
				max = nums[index];
				if (index == nums.length-2){ // special case for the tail
					if (max == min){
						ranges.add(Integer.toString(min));
						ranges.add(Integer.toString(nums[index+1]));
						}
					else{
						ranges.add(Integer.toString(min) + "->" + Integer.toString(max));
						ranges.add(Integer.toString(nums[index+1]));
					}
				}
				else {
					if (max == min)
						ranges.add(Integer.toString(min));
					else
						ranges.add(Integer.toString(min) + "->" + Integer.toString(max));
					
					min = nums[index+1];
				}
				
			}
			else if (index == nums.length-2){ // special case for the tail
				max = nums[nums.length-1];
				ranges.add(Integer.toString(min) + "->" + Integer.toString(max));
				
			}
		}

		return ranges;
		
	}
	
	// Solution 2 260ms
	public static Vector<String> SummaryRanges_2(int[] nums){
		Vector<String> ranges = new Vector<String>();
		
		if (nums.length == 0 || nums == null) 
			return ranges;
		
		int i = 0, size = nums.length;
		int min = nums[i], max = nums[i];
		while (i < size){
			while ((i < size-1) && (nums[i+1] - nums[i] == 1)){
				i++;
			}
			max = nums[i];
			if (max == min)
				ranges.add(Integer.toString(min));
			else
				ranges.add(min + "->" + max);
			i++;
			
			if (i < size)
				min = nums[i];
		}
		return ranges;
	}
}
