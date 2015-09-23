
public class PlusOne {

	/** 66 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a non-negative number represented as an 
	 * array of digits, plus one to the number.
	 * 
	 * The digits are stored such that the most 
	 * significant digit is at the head of the list.
	 * 
	 * @param digits
	 * @return
	 */
	// Solution 1 Plus any number < 10 312 ms
	public static int[] plusOne_1(int[] digits){
		int size = digits.length;
		int i = size - 1, carryon = 1, sum = 0;
		while (carryon != 0 && i > -1){
				sum = digits[i] + carryon;
				digits[i] = sum % 10;
				carryon = sum > 9 ? 1 : 0;
			
			i--;
		}
		
		if (i < 0 && carryon == 1){
			int[] digits_copy = new int[size+1];
			for (int j = 0; j < size; j++)
				digits_copy[j] = digits[j];
			digits_copy[0] = 1;
			return digits_copy;
		}
			
		return digits;
	}
	
	// Solution 2 272 ms
	// Reference: https://leetcode.com/discuss/46786/simple-java-solution
	public static int[] plusOne_2(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
	        if (digits[i] != 9) {
	            digits[i]++;
	            break;
	        } else {
	            digits[i] = 0;
	        }
	    }
	    if (digits[0] == 0) {
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	    return digits;
    }

}
