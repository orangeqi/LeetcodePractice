
public class ExcelSheetColumnNumber {

	/** 171 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ZZ"));
	}
	
	// Solution 324ms
	/**
	 * Given a column title as appear in an Excel sheet, return its corresponding column number.
	 * For example:
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
	 * @param s
	 * @return
	 */
	public static int titleToNumber(String s) {
        char[] sChar = s.toCharArray();
        int result = 0;
        for (char c : sChar){
        	result = result*26 + Character.valueOf(c) - Character.valueOf('A') + 1;
        }
        return result;
    }
}
