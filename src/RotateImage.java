
public class RotateImage {

	/** 48 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{8,0,4},{7,6,5}};//{{1}};//{{1,2},{4,3}};
		rotate(matrix);
		for(int[] row : matrix){
			for (int num : row)
				System.out.print(num);
			System.out.println();
		}
	}

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * Rotate the image by 90 degrees (clockwise).
	 * Follow up:
	 * Could you do this in-place?
	 * 
	 * [i,j]...[j,m-1-i]
	 * [i,j]...[m-1-i,m-1-j]
	 * 
	 * @param matrix
	 */
	// Solution 1 276 ms
	public static void rotate(int[][] matrix){
		int m = matrix.length;
		if (m == 0) return;
		
		for (int i = 0; i < m-1; i++){
			for (int j = i; j < m-1-i; j++){
				int temp1 = matrix[j][m-1-i];
				int temp2 = matrix[m-1-i][m-1-j];
				matrix[j][m-1-i] = matrix[i][j];
				matrix[m-1-i][m-1-j] = temp1;
				temp1 = matrix[m-1-j][i];
				matrix[m-1-j][i] = temp2;
				matrix[i][j] = temp1;
			}
		}
	}
}
