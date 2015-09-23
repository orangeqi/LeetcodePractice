import java.util.Stack;


public class SimplifyPath {

	/** 71 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/.."));
		//"/a/./b/..////..//c/"
	}

	/**
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * For example,
	 * path = "/home/", => "/home"
	 * path = "/a/./b/../../c/", => "/c"
	 * 
	 * @param path
	 * @return
	 */
	// Solution 336 ms
	public static String simplifyPath(String path){
		Stack<String> stack = new Stack<String>();
		int i = -1;
		String res = "";
		
		while (i < path.length()){
			String e = "";
			i++;
			while (i < path.length() && path.charAt(i) != '/'){
				e += path.charAt(i);
				i++;
			}
			if (e.equals("") || e.equals("."))
				continue;
			// corner case /../ return /
			else if (!stack.isEmpty() && e.equals(".."))
				stack.pop();
			else if (!e.equals(".."))
				stack.push(e);
		}
		
		if (stack.isEmpty()) 
			return "/";
		
		while (!stack.isEmpty()){
			res = "/" + stack.pop() + res;
		}
		return res;
	}
	
	// Solution 2 320 ms
	// Reference: https://leetcode.com/discuss/45927/fast-java-sample-code
	public String simplifyPath_2(String path) {
	    StringBuffer rst = new StringBuffer();
	    int index = 0;
	    
	    String[] strings = path.split("/");
	    for (String item : strings) {
	        if (item.equals("..")) {
	            if (index > 0)
	                index--;
	        } else if ((item.equals(".")) || (item.equals(""))) {
	            //do nothing
	        } else {
	            strings[index] = item;
	            index++;
	        }
	    }
	    int length = index;
	    while (0 != index) {
	        rst.append("/");
	        rst.append(strings[length - index]);
	        index--;
	    }

	    return (rst.toString().equals("")) ? "/" : rst.toString();

	}
}
