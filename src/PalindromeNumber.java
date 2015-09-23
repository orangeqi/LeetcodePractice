
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(isPalindrome_3(12321))
			System.out.println("true");
		else
			System.out.println("false");
	}

	// Solution 1 924 ms
	public static boolean isPalindrome_1(int x) {
		char[] xChar = Integer.toString(x).toCharArray();
		int size = xChar.length;
		int ind = 0;
		while (ind < size/2){
			if (xChar[ind] != xChar[size-1-ind])
				return false;
			ind++;
		}
		return true; 
	}
	
	// Solution 2 588 ms
	// Reference: https://leetcode.com/discuss/42934/accepted-java-solution-with-short-lines
	public static boolean isPalindrome_2(int x) {
		 int temp = Math.abs(x);
	        int n = temp % 10;
	        while(temp / 10 != 0){
	            temp = temp / 10;    
	            n = n * 10 + temp % 10; 
	        }
	        if(n == x){
	            return true;
	        }
	        return false;
	}
	
	// Solution 3 548 ms
	// Reference: https://leetcode.com/discuss/38710/easy-java-solution-without-extra-space
	public static boolean isPalindrome_3(int x) {
	    if(x < 0) return false;
	    if(x == 0) return true;

	    int size = 0;
	    int tmp = x;
	    while(tmp > 0)
	    {
	        size++;
	        tmp /= 10;
	    }
	    int i = 0,j = size - 1;
	    for(;i < j;i++,j--)
	    {
	        int h = x/(int)Math.pow(10, j)%10;
	        int l = x/(int)Math.pow(10, i)%10;
	        if(h != l) return false;
	    }
	    return true;       
	}
	
}
