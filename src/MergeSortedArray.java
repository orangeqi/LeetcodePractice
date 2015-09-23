
public class MergeSortedArray {

	/** 88 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[2];
		nums1[0] = 1;
		int[] nums2 = {2};
		merge(nums1, 1, nums2, 1);
		for (int i = 0; i < nums1.length; i++)
			System.out.println(nums1[i]);
	}

	/**
	 * Given two sorted integer arrays nums1 and nums2, 
	 * merge nums2 into nums1 as one sorted array.
	 * Note:
	 * You may assume that nums1 has enough space 
	 * (size that is greater or equal to m + n) to hold 
	 * additional elements from nums2. 
	 * The number of elements initialized in nums1 
	 * and nums2 are m and n respectively.
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	// Solution 1 264 ms
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = m-1, pt2 = n-1, i = m+n-1;
		while (pt1 > -1 && pt2 > -1){
			if (nums1[pt1] > nums2[pt2])
				nums1[i--] = nums1[pt1--]; 
			else
				nums1[i--] = nums2[pt2--];
        }
		while (pt2 > -1)
			nums1[i--] = nums2[pt2--];
    }
	
}
