import java.util.Stack;


public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome_2("fdgagedf"));
	}
	/**
	 * Given a string S, find the longest palindromic substring in S. 
	 * You may assume that the maximum length of S is 1000, 
	 * and there exists one unique longest palindromic substring.
	 * @param s
	 * @return
	 */
	
	// Solution 1 464ms
	// Reference: https://leetcode.com/discuss/37727/my-short-simple-java-solution-o-n-2
	public static String longestPalindrome_1(String s) {
        if (s.length()==0 || s.length()==1) return s;
        char[] arr=s.toCharArray();
        int longest=0;
        int saveL=0;
        int saveR=0;
        for(int l=0;l<arr.length;l++) { 
            for(int r=l;r<arr.length;r++) {
                int palLen=r-l+1;
                if (palLen < longest) { continue; }
                int p=l;
                int q=r;
                while (q>=p) {
                    if (!(arr[p]==arr[q])) break;
                    p++;
                    q--;
                }
                if (q<p && palLen>longest) {
                    longest=palLen;
                    saveL=l;
                    saveR=r;
                }
            }
        }
        retur s.substring(saveL,saveR+1);
    }
	
	// Solution 2 Gusfield's Algorithm 296 ms
	// Reference: https://leetcode.com/discuss/42104/gusfields-algorithm-solve-longest-palindromic-substring
	public static String longestPalindrome_2(String s) {
	    char[] temp = new char[1001*2];
	    int[] z=new int[1001 * 2];
	    int L=0, R=0;
	    int len=s.length();

	    for(int i=0;i<len*2+1;i++){
	        temp[i]='.';
	    }

	    for(int i=0;i<len;++i){
	        temp[i*2+1] = s.charAt(i);
	    }

	    z[0]=1;
	    len=len*2+1;

	    for(int i=0;i<len;i++){
	        int ii = L - (i - L);  
	        int n = R + 1 - i;
	        if (i > R)
	        {
	            z[i] = match(temp, i, i,len);
	            L = i;
	            R = i + z[i] - 1;
	        }
	        else if (z[ii] == n)
	        {
	            z[i] = n + match(temp, i-n, i+n,len);
	            L = i;
	            R = i + z[i] - 1;
	        }
	        else
	        {
	            z[i] = (z[ii]<= n)? z[ii]:n;
	        } 
	    }

	    int n = 0, p = 0;
	    for (int i=0; i<len; ++i)
	        if (z[i] > n)
	            n = z[p = i];

	    StringBuilder result=new StringBuilder();
	    for (int i=p-z[p]+1; i<=p+z[p]-1; ++i)
	        if(temp[i]!='.')
	            result.append(String.valueOf(temp[i]));

	    return result.toString();
	}
	public static int match(char[] temp, int a, int b,int len){ 
		int i = 0; 
		while (a-i>=0 && b+i<len && temp[a-i] == temp[b+i]) 
			i++; 
		return i; 
	}
	
	// Solution 3 From center letter 332 ms
	// Reference: https://leetcode.com/discuss/39418/272-ms-java-solution-o-n-2-time-o-1-space
	public static String longestPalindrome_3(String s) {
        int[] result=new int[2];
        result[0]=0; 
        result[1]=0;
        if(s.length()<=1) return s;
        char[] cs=s.toCharArray();
        for(int i=1; i<cs.length; i++){
            int[] x=getPalind(cs,i,0);
            if(x[1]-x[0]>result[1]-result[0]){
                result=x;
            }
            if(cs[i]==cs[i-1]){
                int[] y=getPalind(cs,i,1);
                if(y[1]-y[0]>result[1]-result[0]){
                result=y;
                }
            }
            if(result[1]-result[0]==cs.length-1)
                break;
        }
        return s.substring(result[0], result[1]+1);
    }
    public static int[] getPalind(char[] str,int ind, int typ){
        int[] r=new int[2];
        if(typ==0){
            r[0]=ind;
            r[1]=ind;
        }else{
            r[0]=ind-1;
            r[1]=ind;
        }
        while(r[0]-1>=0&&r[1]+1<str.length){
            if(str[r[0]-1]==str[r[1]+1]){
                r[0]--;
                r[1]++;
            }else break;
        }
        return r;
    }
    
	// Wrong answer
	public static String longestPalindrome_4(String s) {
		if (s == null || s.length() == 1) return s;
		
        Stack<Character> stack = new Stack<Character>();
        int count = 0, max = 0, ind = 0, mid = 0;
        char c = '0';
        int addone = 0;
        for (int i = 0; i < s.length(); i++){
        	c = s.charAt(i);
        	if (i > 0){
        		if (!stack.isEmpty() && stack.peek() == c){
        			stack.pop();
        			count++;
        		}
        		else if (!stack.isEmpty() && mid == 1){
        			stack.pop();
        			if (!stack.isEmpty() && stack.peek() == c){
            			stack.pop();
            			count++;
            			addone = 1;
            			stack.clear();
            		}
        		}
        		else{
        			if (count > max){
        				max = count;
        				ind = i;
        				stack.clear();
        				count = 0;
        				mid = 0;
        				addone = 0;
        			}
        			if (i>0)
        				mid++;
        			stack.push(c);
        		}
        	}
        	else stack.push(c);
        	
        }
        if (count > max && stack.isEmpty()){
			return s.substring(s.length() - 2*count - addone);
        }
        else if (count > max){
        	return s.substring(s.length() - 1 - 2*count - addone);
        }
        return s.substring(ind - 2*max - addone, ind);
    }
}
