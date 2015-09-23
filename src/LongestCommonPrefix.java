
public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(longestCommonPrefix(new String[]{"baaa", "c", "bfd"}));
	}
	
	/**
	 * Write a function to find the longest common prefix string 
	 * amongst an array of strings.
	 * (All strings start with the same letters)
	 * 
	 * @param strs
	 * @return
	 */
	// Solution 1 300 ms
	public static String longestCommonPrefix(String[] strs){
		if (strs.length == 0) return "";
		
		String lcp = strs[0];
		for (int i = 1; i < strs.length; i++){
			StringBuilder res = new StringBuilder();
			for (int k = 0; k < Math.min(strs[i].length(),
					lcp.length()); k++){
				if (strs[i].charAt(k) == lcp.charAt(k))
					res.append(strs[i].charAt(k));
				else
					break;
			}
			lcp = res.toString();
			if (lcp == "") return lcp;
		}

		return lcp;
	}
}
