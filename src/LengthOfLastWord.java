
public class LengthOfLastWord {

	/** 58 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("Hello World"));
	}

	// Solution 1 252 ms
	public static int lengthOfLastWord(String s){
		if (s == null || s.length() == 0) return 0;
		
		int i = s.length() - 1;
		int count = 0;
		while (i > -1 && s.charAt(i) == ' ')
			i--;
		while (i > -1 && s.charAt(i) != ' '){
			count++;
			i--;
		}
		return count;
	}
}
