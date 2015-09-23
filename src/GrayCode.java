import java.util.ArrayList;


public class GrayCode {

	/** 89 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(3));
	}

	/**
	 * The gray code is a binary numeral system where two 
	 * successive values differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of 
	 * bits in the code, print the sequence of gray code. A gray code 
	 * sequence must begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 * 
	 * Note:
	 * For a given n, a gray code sequence is not uniquely defined.
	 * For example, [0,2,3,1] is also a valid gray code sequence 
	 * according to the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of 
	 * gray code sequence. Sorry about that.
	 * 
	 * 000,001,011,010,110,100,101,111
	 * @param n
	 * @return
	 */
	// Solution 1 224 ms
	public static ArrayList<Integer> grayCode(int n){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		res.add(0);
		if (n == 0) return res;
		res.add(1);
		if (n == 1) return res;
		
		for (int k = 1; k < n; k++){
			for (int i = res.size()-1; i > -1; i--){
				res.add((int)(res.get(i) + Math.pow(2, k)));
			}
		}
		return res;
	}
}
