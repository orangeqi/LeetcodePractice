import java.util.HashSet;


public class ValidSudoku {

	/** 36 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Determine if a Sudoku is valid, according to:
	 * Sudoku Puzzles - The Rules.
	 * The Sudoku board could be partially filled, 
	 * where empty cells are filled with the character '.'.
	 * 
	 * @param board
	 * @return
	 */
	// Solution 1 340 ms
	public boolean isValidSudoku(char[][] board) {
        // horizontal
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++){
			set.clear();
        	for (int j = 0; j < 9; j++){
        		if (board[i][j] == '.')
        			continue;
        		if (set.contains(board[i][j]))
        			return false;
        		else
        			set.add(board[j][i]);
        	}
        }
		
		// verticle
		for (int i = 0; i < 9; i++){
			set.clear();
			for (int j = 0; j < 9; j++){
				if (board[j][i] == '.')
        			continue;
        		if (set.contains(board[j][i]))
        			return false;
        		else
        			set.add(board[i][j]);	
        	}
        }
		
		// 3x3
		for (int k = 0; k < 9; k+=3){
			for (int n = 0; n < 9; n+=3){
				set.clear();
				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						if (board[i+k][j+n] == '.')
		        			continue;
		        		if (set.contains(board[i+k][j+n]))
		        			return false;
		        		else
		        			set.add(board[i+k][j+n]);
					}
				}
			}
		}
		return true;
		
    }
}
