
public class HappyNumber {

	/** 202 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (isHappy(7)) System.out.println("happy");
		else System.out.println("sad");
	}
	
	/**
	 * Write an algorithm to determine if a number is "happy".

		A happy number is a number defined by the following process: 
		Starting with any positive integer, replace the number by 
		the sum of the squares of its digits, and repeat the process
		until the number equals 1 (where it will stay), or it loops
		endlessly in a cycle which does not include 1. Those numbers 
		for which this process ends in 1 are happy numbers.
		
		Example: 19 is a happy number
		
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1

	 * @param n
	 * @return
	 */
	// Solution 1 256 ms
	public static boolean isHappy(int n) {
		int ans, a = n, count = 100;
        while (count > 0){
        	ans = 0;
        	while (a > 9){
        		ans = ans + (int)Math.pow(a%10, 2);
        		a = a/10;
          	}
        	ans = ans + (int)Math.pow(a, 2);
        	if (ans == 1) return true;
        	a = ans;
        	count--;
        }
        return false;
    }
}
