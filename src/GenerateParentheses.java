import java.util.ArrayList;
import java.util.Stack;


public class GenerateParentheses {

	/** 22 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}
    
	
	/**
	 * Given n pairs of parentheses, write a function 
	 * to generate all combinations of well-formed 
	 * parentheses. For example, given n = 3, a solution 
	 * set is:
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 * @param n
	 * @return
	 */
	
	// Solution 1 264 ms
	// whenever number of "(" is not 0 we can place one more
	// each time there is a "(" we need a ")"
	public static Stack<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<String>();
		g_helper(stack, "(", n*2, 1, n-1);
		return stack;
    }
	
	// m number of parentheses left, indb whether to place a ")", indf number of "(" left.
	private static void g_helper(Stack<String> a, String str, int m, int indb, int indf){
		if (m < 2){
			a.add(str);
			return;
		}
		
		if (indf > 0){
			g_helper(a, str+"(", m-1, indb+1, indf-1);
		}
		if (indb > 0){ // indf <= indb
			g_helper(a, str+")", m-1, indb-1, indf);
		}
	}
	
	// Solution 2 256 ms
	// Reference: https://leetcode.com/discuss/36837/my-java-solution-dfs
    public static ArrayList<String> generateParenthesis_2(int n) {
    	ArrayList<String> a = new ArrayList<String>();
        dfs(a, "(", 1, 0, n);
            return a;
        }
    public static void dfs(ArrayList<String> a, String s, int left, int right, int size){
        if(left > size || right > size || right > left)
            return;
        if(left==right && left==size){
            a.add(s);
            return;
        }
        dfs(a, s+"(",left+1, right, size);
        dfs(a, s+")",left, right+1, size);
    }
}
