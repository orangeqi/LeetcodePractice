
public class UniquePaths {

	/** 62 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(2,2));
	}

	/**
	 * A robot is located at the top-left corner of 
	 * a m x n grid (marked 'Start' in the diagram below).
	 * 
	 * The robot can only move either down or right at 
	 * any point in time. The robot is trying to reach 
	 * the bottom-right corner of the grid (marked 'Finish' 
	 * in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	
	// Solution 2 212 ms
	// Reference: https://leetcode.com/discuss/46023/java-ac-dp-solution
	public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++)
            grid[i][0] = 1;
        for(int i = 1; i < n; i++)
            grid[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}
