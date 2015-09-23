
public class ZigzagConversion {

	/** 6 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("ABCDEFGHIJKLN", 4));
	}

	// Solution 1 428 ms
	// Reference: https://leetcode.com/discuss/42047/straightforward-java-solution
	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on 
	 * a given number of rows like this: (you may want to display this 
	 * pattern in a fixed font for better legibility)
	 * P   A   H   N
	 * A P L S I I G
	 * Y   I   R
	 * And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion 
	 * given a number of rows:
	 * 
	 * string convert(string text, int nRows):
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows){
		// chunk = # of chars in a pair of long short cols
		int chunk = Math.max(numRows * 2 - 2, numRows); // numRows = 1
	    StringBuilder result = new StringBuilder();

	    for (int row = 0; row < numRows; row++) {
	        for (int i=0; i < s.length(); i += chunk) {
	            if (i + row < s.length()) // unable to fill up a col
	                result.append(s.charAt(i + row));
	            if (row > 0 && row < numRows - 1 && (i + chunk - row < s.length()))
	                result.append(s.charAt(i + chunk - row));
	        }
	    }
	    return result.toString();
	}
}
