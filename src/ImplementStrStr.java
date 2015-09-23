
public class ImplementStrStr {

	/** 28 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("mississippi", "issipi"));
	}

	/**
	 * Implement strStr function, find the index of first
	 * occurrence of a string inside another string
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	// Solution 1 288 ms
	public static int strStr(String haystack, String needle){
		for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) return i;
		      if (i + j == haystack.length()) return -1;
		      if (needle.charAt(j) != haystack.charAt(i + j)) break;
		    }
		 }
	}
	
	
}
