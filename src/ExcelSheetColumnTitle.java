
public class ExcelSheetColumnTitle {

	/** 168 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle_1(702));
	}
	
	/**
	 * Given a positive integer, return its corresponding 
	 * column title as appear in an Excel sheet.
	 * For example:
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
	    
	    ... + 26^3*a3 + 26^2*a2 + 26^1*a1 + 26^0*a0
	    ZZ->26^2*1 + 26^1*1
	 * @param n
	 * @return
	 */
	// Solution 1 220ms
	public static String convertToTitle_1(int n) {
		int result = n, m, val = Character.valueOf('A') -1;
		String out = "";
        while(result > 26){
        	m = result%26;
        	if (m == 0){
        		out = (char)(val + 26) + out;
        		result = result/26 - 1;
        	}
        	else{
        		out = (char)(val + m) + out;
        		result = result/26;
        	}
        }
        
        out = (char)(val + result) + out;        
        return out;
    }
	
	// Solution 2 196 ms
	public static String convertToTitle_2(int n) {
		 String result="";
	     while(n > 26){ 
	         int a = n % 26; 
	         if(a != 0){ 
	             result = (char)(a + 64) + result; 
	             n = n / 26; 
	         }
	         else{ 
	             result = (char)(26 + 64) + result; 
	             n = n / 26 - 1; 
	         }
	     }
	     result = (char)(n + 64) + result;
	     return result;
     }

}
