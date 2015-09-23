
public class MinimumPathSum {

	/** 64 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]
				{{1,3,1},
				 {1,5,1},
				 {4,2,1}};
		System.out.println(minPathSum_1(matrix));
	}

	// Solution 1 384 ms
	public static int minPathSum_1(int[][] grid){
		int m = grid.length, n = grid[0].length;
	
		int[][] min = new int[m][n];
		min[0][0] = grid[0][0];
		
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if (j - 1 < 0 && i - 1 < 0){
					min[i][j] = grid[i][j];
				}
				else if (j - 1 < 0){
					min[i][j] = grid[i][j] + min[i-1][j];
				}
				else if (i - 1 < 0){
					min[i][j] = grid[i][j] + min[i][j-1];
				}
				else{		
					if (grid[i][j]+min[i][j-1] < grid[i][j]+min[i-1][j])
						min[i][j] = grid[i][j]+min[i][j-1];
					else
						min[i][j] = grid[i][j]+min[i-1][j];
				}
			}
		}
		return min[m-1][n-1];
	}
	
	// Solution 2 412 ms
	// Reference: https://leetcode.com/discuss/38589/share-my-ac-java-solution-with-o-m-n-time-o-1-space
	public static int minPathSum_2(int[][] grid) {
	    int row = grid.length;
	    if (row == 0) {
	        return 0;
	    }
	    int col = grid[0].length;

	    for (int i = 1; i < row; i ++) {
	        grid[i][0] += grid[i - 1][0];
	    }

	    for (int j = 1; j < col; j ++) {
	        grid[0][j] += grid[0][j - 1];
	    }

	    for (int i = 1; i < row; i ++) {
	        for (int j = 1; j < col; j ++) {
	            grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
	        }
	    }
	    return grid[row - 1][col - 1];
	}
	
	// Solution 3 dynamic programming 360 ms
	public int minPathSum(int[][] grid) {
        return minPathSum(grid,0,0,new int[grid.length][grid[0].length]);
    }
    public static int minPathSum(int[][] grid, int i, int j, int[][] cache) {
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(cache[i][j]>0) return cache[i][j];
        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(i+1<grid.length) down = minPathSum(grid,i+1,j,cache);
        if(j+1<grid[i].length) right = minPathSum(grid,i,j+1,cache);
        cache[i][j] = grid[i][j]+Math.min(down,right);
        return cache[i][j];
	    
    }
	
}
