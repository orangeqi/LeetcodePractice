
public class ReverseBits {

	/** 190 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits_2(2));

	}
	
	/**
	 * Reverse bits of a given 32 bits unsigned integer.
	 * For example, given input 43261596 (represented in binary 
	 * as 00000010100101000001111010011100), return 964176192 
	 * (represented in binary as 00111001011110000010100101000000).
	 * 
	 * @param n 
	 * @return
	 */
	// Solution 1 can not solve unsigned int problem
	public static int reverseBits_1(int n) {		
		String bin = Integer.toBinaryString(n);
		int output = 0;
		int pow = 31;
		
		for (int i = bin.length()-1; i > -1; i--){
			if (bin.charAt(i) == '1'){
				output = output + (int)Math.pow(2, pow);
			}
			pow--;
		}
        return output;
    }
	
	// Solution 2 312 ms
	 public static int reverseBits_2(int n) {
	    int result = 0;
		for (int i = 0; i < 32; ++i) {
			result = result<<1  | (n & 1);
			n >>>= 1;
		}
		return result; 
	 }
	
	 // Solution 3 296 ms
	public static int reverseBits_3(int n) {
        int reverse = 0;
        for(int i = 0; i < 32; i++){
            int temp = n << i;
            temp = temp >>> 31 << i;
            reverse += temp;
        }
        return reverse;
    }
}
