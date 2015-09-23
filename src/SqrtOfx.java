
public class SqrtOfx {

	/** 69 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt_1(2));
	}
	

	/**
	 * Implement int sqrt(int x).
	 * Compute and return the square root of x.
	 * 
	 * @param x
	 * @return
	 */
	// Solution 1 binary search 268 ms
	// reference:https://leetcode.com/discuss/31804/share-my-accepted-java-solution-using-binary-search 
	// double cast to int always ignore decimal part
	public static int mySqrt_1(int x) {
	 	if (x == 0) 
            return 0;
        
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) / 2;
            int tmp = x / mid;
            if (mid == tmp) {
                return mid;
            } else if(mid > tmp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
	
	// Solution 2 Newtown's method 312 ms
	// Reference: https://leetcode.com/discuss/41367/newtons-method-with-only-one-variable
	// x[n+1] = x[n] - f(x[n])/f'(x[n])
	// f(x) = x^2 - a
	// f'(x) = 2x
	// x[n+1] = x[n] - x[n]/2 + a/(2x[n]) = (x[n] + a/x[n])/2
	// in this case a = x
	public static int mySqrt_2(int x) {
        double x0 = 1;
        do{
            x0 = (x0+ x/x0)/2;
        }while(Math.abs(Math.pow(x0, 2) - x) >= 1);
        return (int)x0;
    }
}
