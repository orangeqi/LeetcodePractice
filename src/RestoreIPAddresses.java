import java.util.ArrayList;


public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("010010"));
	}
	
	// Solution 1 320 ms
	public static ArrayList<String> restoreIpAddresses(String s){
		ArrayList<String> res = new ArrayList<String>();
		helper(s, 4, res, "");
		return res;
	}
	private static void helper(String s, int count, ArrayList<String> res, String each){
		if (count == 0 && s.length() == 0){
			res.add(each.substring(0, each.length()-1));
			return;
		}
		else if (count == 0 && s.length() != 0){
			return;
		}
			
		for (int i = 1; i < 4; i++){
			if (s.length() < i) break;
			String temp = new String(each);
			if ((i > 1 && s.subSequence(0, 1).equals("0")) ||
					(i == 3 && Integer.valueOf(s.substring(0, i)) > 255))
				break;
			temp += s.substring(0, i) + ".";
			helper(s.substring(i), count-1, res, temp);
		}
		return;
	}
}
