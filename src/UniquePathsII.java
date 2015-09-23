
public class UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]
				{{0,1}};
		System.out.println(uniquePathsWithObstacles(matrix));
	}

	/**
	 * Now consider if some obstacles are added to the grids. 
	 * How many unique paths would there be?
	 * An obstacle and empty space is marked as 1 and 0 
	 * respectively in the grid.
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	// Solution 1 308 ms
	public static int uniquePathsWithObstacles(int[][] obstacleGrid){
	      int m = obstacleGrid.length,
					n = obstacleGrid[0].length;
			
	      // set available edge spot to -1
			for (int i = 0; i < m; i++){
				if (obstacleGrid[i][0] != 1)
					obstacleGrid[i][0] = -1;
				else
					break;
			}
			for (int j = 0; j < n; j++){
				if (obstacleGrid[0][j] != 1)
					obstacleGrid[0][j] = -1;
				else
					break;
			}
			
			for (int i = 1; i < m; i++){
				for (int j = 1; j < n; j++){
					if (obstacleGrid[i][j] != 1){
						if (obstacleGrid[i-1][j] != 1 &&
							obstacleGrid[i][j-1] != 1)
							obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
						else if (obstacleGrid[i-1][j] != 1)
							obstacleGrid[i][j] = obstacleGrid[i-1][j];
						else
							obstacleGrid[i][j] = obstacleGrid[i][j-1];
					}
				}
			}
			if (obstacleGrid[m-1][n-1] == 1)
			    return 0;
			return -obstacleGrid[m-1][n-1];
	}
}
