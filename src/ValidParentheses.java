import java.util.Stack;


public class ValidParentheses {

	/** 20 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("]"));
	}
	
	
	/**
	 * Given a string containing just the characters 
	 * '(', ')', '{', '}', '[' and ']', determine if 
	 * the input string is valid. The brackets must close
	 * in the correct order, "()" and "()[]{}" are all 
	 * valid but "(]" and "([)]" are not.
	 * @param s
	 * @return
	 */
	// Solution 1 264 ms
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{'){
				stack.push(c);
			}
			else if (c == ')'){
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
			}
			else if (c == ']'){
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
			}
			else if (c == '}'){
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
			}
		}
		if (!stack.isEmpty()) return false;
		return true;
    }
}
