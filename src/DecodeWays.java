
public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("1222"));
	}
	public static int numDecodings(String s){
		if (s.length() == 0) return 0;
		return helper(s, 0);
	}
	private static int helper(String s, int count){
		if (s.length() == 0){
			return count+1;
		}
		for (int i = 1; i < 3; i++){
			if (i == 2 && (s.length() < 2
					|| s.charAt(0) == '0' 
					|| Integer.valueOf(s.substring(0, i)) > 26))
				break;
			count = helper(s.substring(i), count);
		}
		return count;
	}

}
