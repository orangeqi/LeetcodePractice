
public class AddBinary {

	/** 67 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1011","101"));
	}

	/**
	 * Given two binary strings, return their sum (also a binary string).

		For example,
		a = "11"
		b = "1"
		Return "100".
		
	 * @param a
	 * @param b
	 * @return
	 */
	// Solution 1 312 ms
	public static String addBinary(String a, String b){
		int size_a = a.length(), size_b = b.length();
		int i = size_a-1, j = size_b-1, carryon = 0;
		int aa, bb;
		String result = "";
		while(i > -1 || j > -1 || carryon != 0){
			aa = (i > -1) ? Integer.parseInt(a.substring(i,i+1)) : 0;
			bb = (j > -1) ? Integer.parseInt(b.substring(j,j+1)) : 0;
			result = (aa+bb+carryon)%2 + result;
			carryon = (aa+bb+carryon)/2;
			i--;
			j--;
		}
		return result;
	}
}
