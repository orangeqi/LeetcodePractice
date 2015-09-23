
public class SearchATwoDMatrix {

	/** 74 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{
				{1, 2},
				{3, 4}};
		System.out.println(searchMatrix(matrix, 5));
	}

	/**
	 * Write an efficient algorithm that searches for a value 
	 * in an m x n matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right.
	 * The first integer of each row is greater than the
	 * last integer of the previous row.
	 * 
	 * For example, Consider the following matrix:

		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]

	 * Given target = 3, return true.
	 * @param matrix
	 * @param target
	 * @return
	 */
	// Solution 1 368 ms
	public static boolean searchMatrix(int[][] matrix, int target){
		int m = matrix.length, n = matrix[0].length;
		if (m == 0) return false;
		
		// Search row
		int r1 = 0, r2 = m-1;
		while (r1 < r2){
			int rmid = (r1 + r2 + 1) / 2;	
			if (matrix[rmid][0] > target)
				r2 = rmid - 1;
			else
				r1 = rmid;
		}
		
		// Search Column
		int c1 = 0, c2 = n-1;
		while (c1 < c2){
			int cmid = (c1 + c2 + 1) / 2;	
			if (matrix[r1][cmid] > target)
				c2 = cmid - 1;
			else
				c1 = cmid;
		}
		
		if (matrix[r1][c1] == target)
			return true;
		else 
			return false;
	}
}
