
public class NumberOfOneBits {

	/** 191 E 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight_2(11000));
	}

	/**
	 * Write a function that takes an unsigned integer and returns 
	 * the number of ’1' bits it has (also known as the Hamming weight).
	 * For example, the 32-bit integer ’11' has binary representation 
	 * 00000000000000000000000000001011, so the function should return 3.
	 * 
	 * @param n input integer
	 * @return number of 1's
	 */
	
	// Solution 1 recursive 292 ms
	public static int hammingWeight_1(int n) {
		String bin = Integer.toBinaryString(n);
		System.out.println(bin);
		return hammingWeight_1_helper(bin);
    }
	
	public static int hammingWeight_1_helper(String n){
		if (n.length() == 1)
			if (n.charAt(0) == '1') return 1;
			else return 0;
		
		if (n.charAt(0) == '1')
			return hammingWeight_1_helper(n.substring(1))+1;
		else 
			return hammingWeight_1_helper(n.substring(1));
	}
	
	// Solution 2 284 ms
	public static int hammingWeight_2(int n){
		String bin = Integer.toBinaryString(n);
		System.out.println(bin);
		int size = bin.length(),
			count = 0;
		for(int i = size-1; i > -1; i--){
			if (bin.charAt(i) == '1') 
				count++;
		}
		return count;
	}
	
	// Solution 3 248 ms
	public int hammingWeight_3(int n) {
	    int val = 0;
	    for (int i = 0; i < 32; i++){
	        if((n & 1) == 1){
	            val++;
	        }
	        n >>>= 1;
	    }
	    return val;
	}
}
