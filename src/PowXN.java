
public class PowXN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(2,-3));
	}
	

	// Solution 1 256 ms
	public static double myPow_1(double x, int n){
		if (n > 0)
			return helper(x, x, n);
		else
			return helper(1/x, 1/x, -n);
	}
	private static double helper(double res, double x, int n){
		if (n == 0) return 1;
		
		if (n%2 == 0){
			return myPow_1(res*res, n/2);
		}
		else{
            return x * helper(res, x, n - 1);
		}
	}

	// Solution 2 276 ms
	// Reference: https://leetcode.com/discuss/37296/my-8-lines-ac-o-logn-solution-in-java
	public static double myPow(double x, int n){
		if (n == 0)
            return 1;

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            if (n > 0)
                return x * myPow(x, n - 1);
            else
                return 1 / x * myPow(x, n + 1);
        }
	}
	
}
