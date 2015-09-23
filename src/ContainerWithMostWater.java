
public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxArea(new int[]{1,4,3,5,2,6}));
	}

	
	/**
	 * Given n non-negative integers a1, a2, ..., an, 
	 * where each represents a point at coordinate (i, ai).
	 * n vertical lines are drawn such that the two endpoints 
	 * of line i is at (i, ai) and (i, 0). Find two lines, 
	 * which together with x-axis forms a container, such 
	 * that the container contains the most water.
	 * Note: You may not slant the container.
	 * 
	 * @param height
	 * @return
	 */
	// Solution 
	// Reference: https://leetcode.com/discuss/38226/java-two-pointer
	// Math.max run faster than if else statement, 
	// Declaring and assigning variables consume more time
	 public static int maxArea(int[] height) {
	        int index1 = 0;
		    int index2 = height.length - 1;
		    int maxArea = 0;
	
		    while (index1 < index2) {
		        int minHeight = Math.min(height[index1], height[index2]);
		        maxArea = Math.max(maxArea, (index2 - index1) * minHeight);
	
		        // Shift smaller one
		        while (minHeight >= height[index1] && index1 < index2) index1++;
		        while (minHeight >= height[index2] && index2 > index1) index2--;
		    }
	
		    return maxArea;
	    }
}
