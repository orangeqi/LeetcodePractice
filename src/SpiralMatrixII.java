
public class SpiralMatrixII {

	/** 59 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] res = generateMatrix(n);
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Given an integer n, generate a square matrix filled 
	 * with elements from 1 to n2 in spiral order.
	 * 
	 * For example:
	 * Given n = 3,
	 * 
	 * You should return the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
	 * @param n
	 * @return
	 */
	// Solution 1 220 ms
	public static int[][] generateMatrix(int n) {
		if (n == 0) return new int[0][0];
		
        int[][] res = new int[n][n];
        
        int e = 1;
        int row = 0, col = -1;
        
        for (int k = 0; k < n; k++){
        	for (int i = 0; i < n-k; i++){
        		if (k % 2 == 0)
        			col++;
        		else
        			col--;
        		res[row][col] = e;
        		e++;
        	}
        	for (int i = 0; i < n-k-1; i++){
        		if (k % 2 == 0)
        			row++;
        		else
        			row--;
        		res[row][col] = e;
        		e++;
        	}
        }
        return res;
    }
}
