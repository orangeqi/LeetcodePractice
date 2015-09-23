import java.util.Stack;


public class ReverseInteger {

	/** 7 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse_3(19082));
	}
	
	/**
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 * 
	 * @param x input integer
	 * @return reverted integer
	 */
	
	// Solution 1 312 ms
	public static int reverse_1(int x) {
		Stack<Character> stack = new Stack<Character>();
		
		String xStr = Integer.toString(Math.abs(x));
		for(int i = 0; i < xStr.length(); i++){
			stack.push(xStr.charAt(i));
		}
		
		String output = "";
		while (!stack.isEmpty())
			output = output + stack.pop();
		
		try{
			int out;
			if (x > 0)
				out = Integer.parseInt(output);
			else 
				out = -Integer.parseInt(output);
	        return out;
		}catch(NumberFormatException e){
			return 0;
		}
    }
	
	// Solution 2 recursive 328 ms
	public static int reverse_2(int x){
		int x_int = Math.abs(x);		
		String xStr = Integer.toString(x_int);

		try{
			int out = Integer.parseInt(reverse_helper(xStr));
			if (x < 0)
				out = -out;
	        return out;
		}catch(NumberFormatException e){
			return 0;
		}
	}
	public static String reverse_helper(String xStr){
		if (xStr.length() == 1) 
			return xStr.substring(0, 1);
		return reverse_helper(xStr.substring(1)) 
				+ xStr.substring(0,1);
	}
	
	// Solution 3 swap 332 ms
	public static int reverse_3(int x){
		char[] xStr = Integer.toString(Math.abs(x)).toCharArray();
		int size = xStr.length, i = 0;
		char temp;
		if (size == 1) return x;
		while (size-i-1-i > 0){
			if (xStr[i] != xStr[size-i-1]){
				// swap
				temp = xStr[i];
				xStr[i] = xStr[size-i-1];
				xStr[size-i-1] = temp;
				}
			i++;
		}
		
		String str = "";
		for(int k=0; k<size; k++)
			str += xStr[k];
		
		try{
			if (x < 0)
				return -Integer.parseInt(str);
			return Integer.parseInt(str);
		}catch(NumberFormatException e){
			return 0;
		}
	}
	
	// Solution 4 280 ms
	public int reverse(int x) {
	       long rev = 0;
	        while( x != 0){
	            rev = rev * 10 + x % 10;
	            x = x / 10;
	            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
	                return 0;
	        }
	        return (int) rev;
		}
}
