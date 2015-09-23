
public class SortColors {

	/** 75 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,2,0};//{2,0}
		sortColors_1(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}

	/**
	 * Given an array with n objects colored red, white or blue, 
	 * sort them so that objects of the same color are adjacent, 
	 * with the colors in the order red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent 
	 * the color red, white, and blue respectively.
	 * 
	 * @param nums
	 */
	// Solution 1 276 ms
	 public static void sortColors_1(int[] nums){
		if (nums.length < 2) return;
		
		// pt1 - pointer of next 0
		// pt2 - pointer of next 1
		// cur - start from first nonzero number in nums
		int cur, pt1 = 0, pt2 = nums.length-1;
		while (pt1 < nums.length && nums[pt1] == 0)
			pt1++;
		while (pt2 > -1 && nums[pt2] == 2)
			pt2--;
		if (pt1 >= pt2) return;
		cur = pt1;
		
		while (cur <= pt2){
			if (nums[cur] == 0 && nums[pt1] != 0){
				swap(nums, cur, pt1);
				pt1++;
			}
			else if (nums[cur] == 0 && nums[pt1] == 0){
				pt1++;
				cur++;
			}
			else if (nums[cur] == 2 && nums[pt2] != 2){
				swap(nums, cur, pt2);
				pt2--;
			}
			else if (cur != pt2 && nums[cur] == 2 && nums[pt2] == 2){
				pt2--;
				swap(nums, cur, pt2);
				pt2--;
			}
			else if (cur == pt2 && nums[cur] == 2 && nums[pt2] == 2){
				return;
			}
			else
				cur++;
		}
	}
	private static void swap(int[] nums, int a, int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
		return;
	}
	
	// Solution 2 276 ms
	// Reference: https://leetcode.com/discuss/48896/my-one-pass-java-solution
	public void sortColors_2(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        
       for(int i = 0;i <= end;){
           if(nums[i] == 2 && i < end) {
               int tmp = nums[end];
               nums[end--] = nums[i];
               nums[i] = tmp;
           }else if(nums[i] == 0 && i > begin){
               int tmp = nums[begin];
               nums[begin++] = nums[i];
               nums[i] = tmp;
           }else{
               i++;
           }
       }
    }
}
