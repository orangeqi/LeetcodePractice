import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Anagrams {

	/** 49 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"", "asdf", "z", "", "fdsa"};
		System.out.println(anagrams_1(strs));
	}
	
	// Solution 1 416 ms
	public static ArrayList<String> anagrams_1(String[] strs){
		ArrayList<String> res = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int i = 0;
		for (String str : strs){
			// sort string
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			String tempStr = new String(temp);
			
			if (map.containsKey(tempStr)){
				int index = map.get(tempStr);
				if (index != -1){
					map.put(tempStr, -1);
					res.add(strs[index]);
				}
				res.add(str);
			}
			else{
				map.put(tempStr, i);
			}
			i++;
		}
		return res;
	}
	
	// Solution 2 Time Limit Exceeded
	public static ArrayList<String> anagrams_2(String[] strs){
		ArrayList<String> res = new ArrayList<String>();
		
		if (strs.length < 2) return res;
		
		boolean firstTime = true;
		for (int i = 0; i < strs.length-1; i++){
			for (int j = i+1; j < strs.length; j++){
				if (strs[i].length() != strs[j].length()){
					continue;
				}
				char[] stra = strs[i].toCharArray();
				Arrays.sort(stra);
				char[] strb = strs[j].toCharArray();
				Arrays.sort(strb);
				
				for(int k = 0; k < strs[i].length(); k++){
					if(stra[k] != strb[k]){
						break;
					}
				}
				if (firstTime) {
					res.add(strs[i]);
					firstTime = false;
				}
				res.add(strs[j]);
			}
		}
		
		return res;
	}
}
