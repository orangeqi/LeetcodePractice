
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
	}
	
	// Solution 1 280 ms
	public static String countAndSay(int n){
		String res = "1";

		for (int i = 0; i < n-1; i++){
			StringBuilder temp = new StringBuilder();
			int count = 1;
			char pre = res.charAt(0);
			for(int j = 1; j < res.length(); j++){
				if (res.charAt(j) != pre){
					temp.append(count);
					temp.append(pre);
					pre = res.charAt(j);
					count = 1;
				}
				else
					count++;
			}
			temp.append(count);
			temp.append(pre);
			res = temp.toString();
		}
		return res;
	}
}
