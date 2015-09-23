
public class SetMatrixZeros {

	/** 73 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]
				{{0,0,0,5},
				 {4,3,1,4},
				 {0,1,1,4},
				 {1,2,1,3},
				 {0,0,1,1}};
		setZeroes_1(matrix);
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
	}

	// Solution 1 Save pos in first row and col 412 ms
	public static void setZeroes_1(int[][] matrix){
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++){
			if (row[i] == 1)
				clear(matrix, i, -1);
		}
		for (int j = 0; j < matrix[0].length; j++){
			if (col[j] == 1)
				clear(matrix, -1, j);
		}
		
	}
	
	private static void clear(int[][] matrix, int i, int j){
		if (j != -1)
			for (int k = 0; k < matrix.length; k++)
				matrix[k][j] = 0;
		if (i != -1)
			for (int k = 0; k < matrix[0].length; k++)
				matrix[i][k] = 0;
	}
	
	// Solution 2 unique number 408 ms
	// Reference: https://leetcode.com/discuss/31640/a-trick-solution-with-o-1-space
	public static void setZeroes_2(int[][] matrix){
		int i,j,k,l, m = matrix.length, n = matrix[0].length;
		for(i=0; i<m; i++) {
		    for(j=0; j<n; j++) {
		        if(0 == matrix[i][j]) {
		            for(k=0; k<m; k++) {
		                if(matrix[k][j] != 0)
		                    matrix[k][j] = -10000; //trick number
		            }
		            for(l=0; l<n; l++) {
		                if(matrix[i][l] != 0)
		                    matrix[i][l] = -10000; //trick number
		            }
		        }
		    }
		}
		for(i=0; i<m; i++) {
		    for(j=0; j<n; j++) {
		        if(-10000 == matrix[i][j])
		            matrix[i][j] = 0;
		    }
		}
	}
}
