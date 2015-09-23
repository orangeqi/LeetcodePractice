import java.util.ArrayList;


public class SpiralMatrix {

	/** 54 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = 
				new int[][]{{1,2}, {3,4}};
//			{
//				{1,2,3},
//				{4,5,6},
//				{7,8,9},
//				{10,11,12}};
		
		System.out.print(spiralOrder(matrix));
	}
	/**
	 * Given a matrix of m x n elements (m rows, n columns), 
	 * return all elements of the matrix in spiral order.
	 * 
	 * For example,
	 * Given the following matrix:

		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ],
		 [10, 11, 12]
		]

	 * You should return [1,2,3,6,9,8,7,4,5].
	 * @param matrix
	 * @return
	 */
	// Solution 1 272 ms
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) return res;
		
		int n = matrix[0].length;
		
		int row = 0, col = -1;
	
		for (int k = 0; k < Math.min(m, n); k++){
	        for (int i = 0; i < n-k; i++){
	        	if (k%2 == 0)
	        		col++;
	        	else
	        		col--;
	        	res.add(matrix[row][col]);
	        }
	        
	        for (int i = 0; i < m-k-1; i++){
	        	if (k%2 == 0)
	        		row++;
	        	else 
	        		row--;
	        	res.add(matrix[row][col]);
	        }
	        
		}
		return res;
    }
}
