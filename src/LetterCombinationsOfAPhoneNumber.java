import java.util.ArrayList;


public class LetterCombinationsOfAPhoneNumber {

	/** 17 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(letterCombinations("237"));
	}
	
	/**
	 * Given a digit string, return all possible letter 
	 * combinations that the number could represent.
	 * A mapping of digit to letters (just like on the 
	 * telephone buttons) is given below.
	 * 
	 * Input:Digit string "23"
	 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 * 
	 * @param digits
	 * @return
	 */
	// Solution 1 recursion 296ms
	public static ArrayList<String> letterCombinations(String digits) {
       ArrayList<String> ans = new ArrayList<String>();
       if (digits == null || digits.length() == 0) return ans;
       l_helper(ans, digits, "");
		return ans;
    }
	
	private static void l_helper(ArrayList<String> ans, String digits, String comb){
		if (digits.length() == 0){
			ans.add(comb);
			return;
		}
		
	   char c = '0';
	   int value = Integer.parseInt(digits.substring(0,1));
	   if (value < 7){
		   for (int i = 0; i < 3; i++){
			   c = (char)(Character.valueOf('a') + (value-2)*3 + i);
			   l_helper(ans, digits.substring(1), comb+c);
		   }
	   }
	   else if (value == 7){
		   for (int i = 0; i < 4; i++){
			   c = (char)(Character.valueOf('p') + i);
			   l_helper(ans, digits.substring(1), comb+c);
		   }
	   }
	   else if (value == 8){
		   for (int i = 0; i < 3; i++){
			   c = (char)(Character.valueOf('t') + i);
			   l_helper(ans, digits.substring(1), comb+c);
		   }
	   }
	   else if (value == 9){
		   for (int i = 0; i < 4; i++){
			   c = (char)(Character.valueOf('w') + i);
			   l_helper(ans, digits.substring(1), comb+c);
		   }
       }
		   
	}
	
}
