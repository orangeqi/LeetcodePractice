
public class WordSearch {

	/** 79 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{
				{'A','B','C'},
				{'D','E','F'},
				{'G','H','I'}};
		System.out.println(exist(board, "BEHI"));
	}

	/**
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * The word can be constructed from letters of sequentially adjacent 
	 * cell, where "adjacent" cells are those horizontally or vertically 
	 * neighboring. The same letter cell may not be used more than once.
	 * 
	 * For example,
	 * Given board =

		[
		  ["ABCE"],
		  ["SFCS"],
		  ["ADEE"]
		]
		word = "ABCCED", -> returns true,
		word = "SEE", -> returns true,
		word = "ABCB", -> returns false.
		
	 * @param board
	 * @param word
	 * @return
	 */
	public static boolean exist(char[][] board, String word){
		int m = board.length, n = board[0].length;
		// find the first letter
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if (board[i][j] == word.charAt(0)){
					boolean res = match(board, word.substring(1), m, n, i, j);
					if (res == true)
						return true;
				}
			}
		}
		return false;
	}
	
	private static boolean match(char[][] board, String word, 
			int m, int n, int row, int col){
		if (word.length() == 0) return true;
		
		char c = word.charAt(0);
		
		if (c == board[(row+1)%m][col])
			return match(board, word.substring(1), m, n, (row+1)%m, col);
		
		if (c == board[row][(col+1)%n])
			return match(board, word.substring(1), m, n, row, (col+1)%n);
		
		if (row == 0 && c == board[m-1][col])
			return match(board, word.substring(1), m, n, m-1, col);
		else if (row-1 > 0 && c == board[row-1][col])
			return match(board, word.substring(1), m, n, row-1, col);
		
		if (col == 0 && c == board[row][n-1])
			return match(board, word.substring(1), m, n, row, n-1);
		else if (col-1 > 0 && c == board[row][col-1])
			return match(board, word.substring(1), m, n, row, col-1);
		
		return false;
		
	}
	
	// Solution 2 364 ms
	// Reference: https://leetcode.com/discuss/47314/my-java-solution-24-lines-easy-to-understand
	public boolean exist(char[][] board, String word) {
	    if (word.length() == 0) return true;
	    if (board.length == 0) return false;
	    boolean[][] usage = new boolean[board.length][board[0].length];
	    for (int i = 0; i < board.length; i++)
	        for (int j = 0; j < board[0].length; j++)
	            if (board[i][j] == word.charAt(0))
	                if (helper(board, usage, word.substring(1), i, j)) return true;
	    return false;
	}
	private boolean helper (char[][] board, boolean[][] usage, String word, int i, int j) {
	    if (word.length() == 0) return true;        
	    usage[i][j] = true;
	    if (i < board.length - 1 && board[i + 1][j] == word.charAt(0) && !usage[i + 1][j])
	        if (helper(board, usage, word.substring(1), i + 1, j)) return true;
	    if (i > 0 && board[i - 1][j] == word.charAt(0) && !usage[i - 1][j])
	        if (helper(board, usage, word.substring(1), i - 1, j)) return true;
	    if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(0) && !usage[i][j + 1])
	        if (helper(board, usage, word.substring(1), i, j + 1)) return true;
	    if (j > 0 && board[i][j - 1] == word.charAt(0) && !usage[i][j - 1])
	        if (helper(board, usage, word.substring(1), i, j - 1)) return true;
	    usage[i][j] = false;
	    return false;
	}
}
